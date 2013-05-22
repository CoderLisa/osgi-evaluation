#OSGI Evaluation - Building a simple bundle with maven bundle plugin

Maven Plugin:

##BND

http://www.aqute.biz/Bnd/Bnd

Primary goal is to remove pains of bundle development.

1. Creates manifest files by analyzing class files and finding dependencies

### BND History
BND roots are 10 years old and can be found as an ant task, cli, Eclipse bundle.  It's bndlib has been used to create
a maven plugin (Apache Felix maven bundle plugin), bndtools, Sigil.

Only BND external connection/dependency is Java 5.  Easy to embed BND in other projects.


##Maven Plugin

http://felix.apache.org/site/apache-felix-maven-bundle-plugin-bnd.html