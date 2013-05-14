# OSGI Framework Evaluation: Knoplerfish

http://www.knopflerfish.org
http://www.knopflerfish.org/releases/current/docs/tutorials/kf_osgi_tutorial/kf_osgi_tutorial.pdf


1. Distribution
  * executable jar file
  * Start with java -jar framework.jar

  PROS: extremely easy to get up and running

2. Management

  * Swing UI
  * Additional mgmt support through bundles: telnet, http, soap



# Questions raised during evaluation

1. CLI for bundle management?

Answer: You can pass cmdline options to the java -jar framework.jar to install/update/etc bundles.  See
http://www.knopflerfish.org/releases/3.5.0/docs/running.html.  You can add remote bundles for extended mgmt options
(telnet, http, soap).

