package equus.carbine.util

import spock.lang.Unroll


@SuppressWarnings("null")
class ErrorMessagesSpec {

    @Unroll
    def "getDifDate #date1, #date2 then return #dif"() {
        expect:
        new DateSupport().getDifDate(date1, date2) == dif

        where:
        date1      |date2      | dif
        "20110331" |"20110331" | 0L
        "20110331" |"20110401" | 1L
        "20110331" |"20110330" | -1L
        "20110331" |"20110501" | 31L
    }
}
