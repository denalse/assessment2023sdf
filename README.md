

1. compiling (slide 8)
 
    javac --source-path src -d classes src/*

2. running the compiled classes (slide 9)
 
    java -cp classes App
 
3. packing to jar (slide 12)

    jar -c -v -f task01.jar -e App . (Do inside bin folder)
> day01.jar - can be any name
 
4. run the jar package (slide 12)

    java -cp bin/task01.jar App
    java -cp task01.jar App (run inside bin folder)