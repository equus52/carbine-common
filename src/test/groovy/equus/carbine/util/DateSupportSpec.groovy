package equus.carbine.util

import static org.hamcrest.CoreMatchers.is
import static org.junit.Assert.assertThat
import spock.lang.Specification
import spock.lang.Unroll


@SuppressWarnings("null")
class DateSupportSpec  extends Specification{

    @Unroll
    def "hasError false"() {
        when:
        ErrorMessages errors = new ErrorMessages()

        then:
        errors.hasError() == false
    }
    @Unroll
    def "hasError true"() {
        when:
        ErrorMessages errors = new ErrorMessages()
        errors.add("message")

        then:
        errors.hasError() == true
    }
    @Unroll
    def "getMessage 1"() {
        when:
        ErrorMessages errors = new ErrorMessages()
        errors.add("message")

        then:
        errors.getMessage() == "message"
    }
    @Unroll
    def "getMessage 2"() {
        when:
        ErrorMessages errors = new ErrorMessages()
        errors.add("message1")
        errors.add("message2")

        then:
        errors.getMessage() == "message1" + System.getProperty("line.separator") + "message2"
    }
}
