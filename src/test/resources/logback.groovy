def appName = "carbine-common"
def patternStr = "%d{yyyy/MM/dd HH:mm:ss:SSS} [%level] [%thread] [%logger{0}] %msg%n"

appender("FILE", RollingFileAppender) {
  encoder(PatternLayoutEncoder) {
    pattern = "${patternStr}"
  }
  rollingPolicy(TimeBasedRollingPolicy) {
    FileNamePattern = "log/${appName}.%d{yyyy-MM-dd}.log"
  }
}

appender("CONSOLE", ConsoleAppender) {
  encoder(PatternLayoutEncoder) {
    pattern = "${patternStr}"
  }
}
root(INFO, ["CONSOLE", "FILE"])