# travis-quest
A concurrency quest.

### To run the project:
1. Clone the repository and navigate to the src directory.
2. Run `javac Main.java`
3. Run `java Main [worker thread type] [number of messages] [number of threads]` 
    where the worker thread type is one of the following options:
    * `--single-printf`
    * `--multi-printf`