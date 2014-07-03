package thegoodproject

import grails.test.mixin.TestFor
import org.junit.Before
import org.junit.Test


@TestFor(VehicleService)
class VehicleServiceTests {
    @Before
    void setup() {
        service.initialize()

        service.addToTrie("trie")
        service.addToTrie("tree")
        service.addToTrie("i")
        service.addToTrie("it")
        service.addToTrie("ite")

        service.addToTrie("f***")
        service.addToTrie("f**d")


    }

    @Test
    void shouldAddAndFindWords() {

      assert "t" == service.wildCardTrie.search("t")
      assert "tr" == service.wildCardTrie.search("tr")
      assert "triex" != service.wildCardTrie.search("triex")

    }

    @Test
    void shouldFindWordWithWoldCards() {

        assert "f**d" == service.wildCardTrie.search("food")
        assert "f**d" == service.wildCardTrie.search("feed")
        assert "f***" == service.wildCardTrie.search("flew")
    }



}
