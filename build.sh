cd aw-report-model
mvn clean install -DskipTests=true
mvn deploy -DskipTests -DaltDeploymentRepository=flipkart::default::http://artifactory.nm.flipkart.com:8081/artifactory/libs-release-local
mvn deploy -DskipTests -DaltDeploymentRepository=flipkart::default::http://artifactory.nm.flipkart.com:8081/artifactory/libs-releases-local
cd ../aw-reporting
mvn clean install -DskipTests=true
mvn deploy -DskipTests -DaltDeploymentRepository=flipkart::default::http://artifactory.nm.flipkart.com:8081/artifactory/libs-release-local
mvn deploy -DskipTests -DaltDeploymentRepository=flipkart::default::http://artifactory.nm.flipkart.com:8081/artifactory/libs-releases-local
cd examples/kratubackend
mvn clean install -DskipTests=true
mvn deploy -DskipTests -DaltDeploymentRepository=flipkart::default::http://artifactory.nm.flipkart.com:8081/artifactory/libs-release-local
mvn deploy -DskipTests -DaltDeploymentRepository=flipkart::default::http://artifactory.nm.flipkart.com:8081/artifactory/libs-releases-local
#java -Xmx4G -jar target/aw-reporting-full.jar -dateRange LAST_30_DAYS -file ~/Desktop/aw-report-sample.properties
