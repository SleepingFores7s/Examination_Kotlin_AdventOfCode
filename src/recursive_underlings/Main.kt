package recursive_underlings

import kotlin.collections.emptyList

/*
Tomtarna på Nordpolen har en strikt chefs-hierarki
Högsta chefen för allt är "Tomten"
Under "Tomten" jobbar "Glader" och "Butter"
Under "Glader" jobbar "Tröger", "Trötter"och "Blyger"
Under "Butter" jobbar "Rådjuret", "Nyckelpigan", "Haren" och "Räven"
Under "Trötter" jobbar "Skumtomten"
Under "Skumtomten" jobbar "Dammråttan"
Under "Räven" jobbar "Gråsuggan" och "Myran"
Under "Myran" jobbar "Bladlusen"

Er uppgift är att illustrera tomtens arbetshierarki i en lämplig datastruktur.
(Det finns flera tänkbara datastrukturer här)

Skriv sedan en funktion där man anger ett namn på tomten eller någon av hens underhuggare som
inparameter.
Funktionen listar sedan namnen på alla underlydande en given person har
Exempel: Du anger "Trötter" och får som svar ["Skumtomten", "Dammråttan"]"

För att bli godkänd på uppgiften måste du använda rekursion.

 */
class Tomteland {

    val treeList = mapOf(
        "Tomten" to listOf("Glader", "Butter"),
        "Glader" to listOf("Tröger", "Trötter", "Blyger"),
        "Butter" to listOf("Rådjuret", "Nyckelpigan", "Haren", "Räven"),
        "Trötter" to listOf("Skumtomten"),
        "Skumtomten" to listOf("Dammråttan"),
        "Räven" to listOf("Gråsuggan", "Myran"),
        "Myran" to listOf("Bladlusen")
    )


    // current namn är den tomte vars underlydande ni vill ta fram
    //res är listan som håller alla underlydande
    fun getUnderlings(currentName: String, res: MutableList<String>): List<String> {

        //Checks if current name have any Underlings
        val currentUnderlings = treeList[currentName] ?: emptyList()
//        val currentUnderlings = if (treeList[currentName] == null) {
//            emptyList()
//        } else {
//            treeList[currentName]
//        }

        //Adds all underlings from current key/Name
        res.addAll(currentUnderlings)

        //Goes another step, and checks if the current underlings have any underlings to add.
        //If list is empty, then the for runs 0 times, because there is 0 elements.
        for (underlingsUnderling in currentUnderlings) {
            getUnderlings(underlingsUnderling, res)
        }

        //Returns completed list of all collected underlings
        return res

    }

    fun main() {

        //Exempel på anrop till den rekursiva funktionen getUnderlings,
        // här är tanken att hitta Tröger underlydande
        //listan fylls på successivt när vi rekurserar

        var list: MutableList<String> = mutableListOf()
        println(getUnderlings("Tröger", list))

    }
}