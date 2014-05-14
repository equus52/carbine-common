import ch.qos.logback.classic.encoder.PatternLayoutEncoder
import ch.qos.logback.core.ConsoleAppender
import ch.qos.logback.core.rolling.RollingFileAppender
import ch.qos.logback.core.rolling.SizeAndTimeBasedFNATP
import ch.qos.logback.core.rolling.TimeBasedRollingPolicy

def appName = "carbine-common"
def patternStr = "%d{yyyy/MM/dd HH:mm:ss:SSS} [%level] [%thread] [%logger{0}] %msg%n"

appender("FILE", RollingFileAppender) {
  encoder(PatternLayoutEncoder) { pattern = "${patternStr}" }
  rollingPolicy(TimeBasedRollingPolicy) {
    fileNamePattern = "log/${appName}.%d{yyyy-MM-dd}.%i.log"
    timeBasedFileNamingAndTriggeringPolicy(SizeAndTimeBasedFNATP){ maxFileSize = "100MB" }
    maxHistory = 30
  }
}

appender("CONSOLE", ConsoleAppender) {
  encoder(PatternLayoutEncoder) { pattern = "${patternStr}" }
}
root(INFO, ["CONSOLE", "FILE"])