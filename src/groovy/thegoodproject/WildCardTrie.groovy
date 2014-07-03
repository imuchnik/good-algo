package thegoodproject;

class WildCardTrie {
    /*root node with empty data*/
    def root = new TrieNode(data:'')

    def insert(key) {
        def trieNode = root
        key.each { character->

            def child = trieNode.children[character]
            if (child == null) {
                child = trieNode.children[character] = new TrieNode(data:character)
            }
            trieNode = child
        }
    }

    def search(key) {
        def foundResult="";
        def trieNode = root
       key.find {
            def nodeFound=trieNode.children[it]
            def wildCard;

            if (nodeFound==null){
                wildCard = trieNode.children['*']
                trieNode=wildCard
            }
            else{
                trieNode=nodeFound
            }
           if (trieNode!=null) {foundResult+=trieNode.data}

            trieNode ==null

        }
      return foundResult

    }
}
