all: doc jeu.jar

doc:
		# génération de la documentation
		javadoc -sourcepath src -d doc -subpackages pandemicMain

cls:
		# compilation des classes
		javac -cp res -sourcepath src -d classes src/pandemicMain/*.java

test: cls
		# tests
		javac -d classes -classpath ./lib/junit-platform-console-standalone-1.9.0.jar ./src/pandemicMain/*.java  ./src/pandemicMain/gfx/*.java ./src/pandemicMain/input/*.java  ./src/pandemicMain/menu/*.java ./src/pandemicMain/ui/*.java ./src/pandemicMain/levels/*.java ./test/pandemicMain/ui/*.java ./test/pandemicMain/mocks/*.java  ./test/pandemicMain/menu/*.java ./test/pandemicMain/gfx/*.java ./test/pandemicMain/levels/*.java ./test/pandemicMain/input/*.java
		java -jar ./lib/junit-platform-console-standalone-1.9.0.jar -cp classes --scan-classpath --disable-banner

jeu.jar: cls
	# construction du jar
	jar cvfm pandemicJ.jar META-INF/MANIFEST.MF -C classes main 
	
jeu:
	# execution du jar
	java -jar jeu.jar


clean:
	# nettoyage des fichiers
	rm -r doc classes *.jar
