**System Design & Architecture: Task Management Service**

# Q:1 How would you scale this service to support 1M requests per day?
To handle 1 million requests per day (approx. 12 requests per second sustained, with spikes), I would implement:

**Horizontal Scaling:** Deploy the application in a Kubernetes (K8s) cluster. I would use a Horizontal Pod Autoscaler (HPA) to scale the number of pods based on CPU/Memory utilization.

**Database Scaling:** Transition from an embedded H2 database to a managed PostgreSQL instance. I would utilize read-replicas to offload GET request traffic from the primary writer node.

**Load Balancing:** Use an Nginx or AWS ALB (Application Load Balancer) to distribute incoming traffic across the healthy service instances.

# Q:2 How would you monitor it in production?
Observability is critical. I would implement the _"Golden Signals"_ framework:

**Metrics (Prometheus & Grafana):** Use Spring Boot Actuator to expose _/actuator/prometheus_ metrics. Grafana dashboards will visualize latency, throughput, and error rates.

**Logging (ELK Stack):** Use structured JSON logging. Logs will be shipped to an Elasticsearch/Logstash/Kibana (ELK) stack to allow for powerful text searching and pattern analysis during production incidents.

**Health Checks:** Use _/actuator/health_ to allow the orchestrator (Kubernetes) to perform liveness and readiness probes.

# Q:3 What CI/CD pipeline would you implement?
I would utilize GitHub Actions to enforce a quality-gate workflow:

**Build Phase:** Triggered on Pull Request to _main_. Executes _./mvnw clean package_.

**Test Phase:** Runs full suite of Unit and Integration tests. If coverage falls below 80%, the build fails.

**Security Phase:** Automated Snyk or GitHub Dependency Scanning to check for vulnerable libraries.

**Deployment:** Upon merge to _main_, the pipeline builds a Docker image, pushes it to an ECR (Container Registry), and triggers a rolling update on the production K8s cluster.

# Q:4 How would AI improve the development lifecycle of this project?
AI can accelerate productivity by:

**Automated PR Triage:** Using an AI tool to suggest reviewers based on the files changed (e.g., if code is modified in the _security/_ package, it flags the Security Lead).

**Predictive Test Selection:** Using historical test data to only run the subset of tests that are likely to fail based on the specific code changes, reducing pipeline execution time.
