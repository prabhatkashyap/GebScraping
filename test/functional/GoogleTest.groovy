import com.MipinParticipant
import geb.junit4.*
import org.junit.Test

import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4)
class GoogleTest extends GebReportingTest {

    @Test
    void theFirstLinkShouldBeWikipedia() {
        to LoginPage

        // wait for the change to results page to happen
        // (google updates the page without a new request)

        when: "I enter root's credentials"
        ctl00$centreContentPlaceHolder$txtEmail = "Enter username for mipim"
        ctl00$centreContentPlaceHolder$txtPassword = "Enter password for mipim"

        then:
        $("#ctl00_centreContentPlaceHolder_btnLogin.button.mainButton").click()

        go 'http://my.mipim.com/en/online-database/mipim/participants/'

        // retry go to driver.currentUrl and click next url and i=i+1
        when:
        String urlOfE=""
        $(".search-req").each{
            if (it.text() == "G") {
                urlOfE = it.attr("href")
            }
        }
//        println("-----------"+urlOfE)

        go "http://my.mipim.com/en/online-database/mipim/participants/#search=d%3D100272%7C0W%26startRecord%3D705%26rpp%3D64"


//        when:
        for (int i = 512; i <= 5000; i = i + 64) {

            when:
            Thread.sleep(25000)
            println("current-" + driver.currentUrl)
            println("page-" + i)
            List urls = []

            $("span.lastName > a").each {
                urls << it.attr("href")
            }
            String nextBtnUrl = $(".gButton>a").attr("href")
            urls.each { String url ->
//                Thread.sleep(2000)
                go url

                when:
                String name = $(".participatingIndividualName.contentMargin").text()
                String email = $(".emailAddress > a").text()
                println("data-" + name + "," + email)
//                if (!MipinParticipant.findByNameAndEmail(name, email)) {
//                    MipinParticipant participant = new MipinParticipant()
//                    participant.name = name
//                    participant.email = email
//                    if (participant.validate()) {
//                        participant.save(flush: true)
//                    }
//                }
//                println("----------count--------" + MipinParticipant.count)
            }

            int s = i
            s = s + 1
            when:
            go "http://my.mipim.com/en/online-database/mipim/participants/#search=d%3D100272%7C0W%26startRecord%3D"+s+"%26rpp%3D64"
//            when:
//            Thread.wait(8000)
        }


    }

}