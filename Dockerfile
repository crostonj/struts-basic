# Use an official Tomcat image with Java 21 support
FROM tomcat:10.1.16-jdk21

# Install necessary tools (e.g., Maven)
RUN apt-get update && apt-get install -y git maven skopeo

# Copy your project files into the container
COPY . /usr/local/tomcat/webapps/myapp/

# List the contents of the copied directory
RUN ls -la /usr/local/tomcat/webapps/myapp/

# Set the working directory
WORKDIR /usr/local/tomcat/webapps/myapp/
# Build the WAR file (if using Maven)
RUN mvn clean package

# Deploy the WAR file (if using Maven)
RUN mv target/*.war /usr/local/tomcat/webapps/basic-struts.war

# Expose Tomcat's port
EXPOSE 8080
EXPOSE 5005
ENV JAVA_OPTS="-agentlib:jdwp=transport=dt_socket,address=5005,server=y,suspend=n"

# Start Tomcat
CMD ["catalina.sh", "run"]
