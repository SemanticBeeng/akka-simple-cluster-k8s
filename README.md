# Simple akka cluster on kubernetes cluster

# Operations

This repository demonstrates how to deploy akka cluster application on kubernetes.

To try it locally on minikube:
```bash
minikube start
eval $(minikube docker-env)
sbt docker:publishLocal

# create serviceAccount $ role, deployment and service

kubectl create -f k8s/akka-cluster.rbac.yml
kubectl create -f k8s/akka-cluster.deployment.yml
kubectl create -f k8s/akka-cluster.service.yml

KUBE_IP=$(minikube ip)
MANAGEMENT_PORT=$(kubectl get svc akka-simple-cluster -ojsonpath="{.spec.ports[?(@.name==\"management\")].nodePort}")

curl http://$KUBE_IP:$MANAGEMENT_PORT/cluster/members | jq
```

```
kubectl delete -f k8s/akka-cluster.rbac.yml
kubectl delete -f k8s/akka-cluster.deployment.yml
kubectl delete -f k8s/akka-cluster.service.yml
```


# Resources

1. https://blog.softwaremill.com/running-akka-cluster-on-kubernetes-e4cd2913e951
1. https://medium.com/stashaway-engineering/running-a-lagom-microservice-on-akka-cluster-with-split-brain-resolver-2a1c301659bd
1. https://developer.lightbend.com/docs/akka-management/current/bootstrap/recipes.html
1. https://developer.lightbend.com/docs/akka-management/current/bootstrap/kubernetes-api.html
1. https://developer.lightbend.com/docs/akka-management/current/bootstrap/details.html
1. https://developer.lightbend.com/docs/akka-management/current/bootstrap/local-config.html
1. https://github.com/akka/akka-management/issues/263
1. https://github.com/akka/akka-management/blob/d369d59da638d8d2cadb46c26300a6a778cd6469/integration-test/kubernetes-api/kubernetes/akka-cluster.yml#L30-L38
1. https://github.com/akka/akka-management/blob/master/cluster-bootstrap/src/main/resources/reference.conf
