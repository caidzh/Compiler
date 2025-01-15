JAVA_RUN_OPTS=-ea -Xss10m -cp /usr/share/java/antlr-4.13.1-complete.jar:bin

.PHONY: build
build:
	find src -name ".antlr" -exec rm -r {} \; &&\
	find src -name '*.java' | xargs javac -d bin -cp /usr/share/java/antlr-4.13.1-complete.jar
.PHONY: run
run: 
	cd bin && java -cp /usr/share/java/antlr-4.13.1-complete.jar:. main

.PHONY: genantlr
genantlr:
	java -jar /usr/share/java/antlr-4.13.1-complete.jar -visitor ./src/Grammar/Mx.g4

.PHONY: Sema
Sema: build
	./testcases/sema/scripts/test.bash 'java $(JAVA_RUN_OPTS) main ' testcases/sema/formatted-string-package/formatted-string1.mx

.PHONY: Semall
Semall: build
	time -p ./testcases/sema/scripts/test_all.bash 'java $(JAVA_RUN_OPTS) main ' testcases/sema/