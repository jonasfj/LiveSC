SOURCES	= $(shell find jtlv/ -name "*.java")
LIBS	= libs/javabdd-2.0.jar:libs/antlr-runtime-3.0.1.jar:libs/jdd.jar
all: Main.jar
applet.jar: jtlv.jar applet.scala
	rm -f applet.jar
	scalac applet.scala -d applet.jar -classpath jtlv.jar:$(LIBS)
Main.jar: jtlv.jar Main.scala
	rm -f Main.jar
	scalac Main.scala -d Main.jar -classpath jtlv.jar:$(LIBS)
test: Main.jar ../examples/WTF.lsc
	clear
	@echo "-------------------------------------------------------------------------------------------------"
	coffee makeSMV.coffee ../examples/WTF.lsc
	java -cp Main.jar:jtlv.jar:libs/scala-library.jar:$(LIBS) Main
shrink: jtlv.jar
	proguard @proguard.options -libraryjars $JAVA_HOME/jre/lib/rt.jar
jtlv.jar:
	mkdir -p bin/jtlv/
	javac -classpath $(LIBS) -d bin/jtlv/ $(SOURCES)
	cd bin/jtlv/; find | xargs jar -cf jtlv.jar; cd -
	cp bin/jtlv/jtlv.jar jtlv.jar
clean:
	rm -rf bin/
	rm -f jtlv.jar
	rm -f Main.jar
