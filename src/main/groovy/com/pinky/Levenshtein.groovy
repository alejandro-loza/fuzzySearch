package com.pinky

class Levenshtein {
    def static int distance(String referenceString, String testString) {
        def referenceStringLenght = referenceString.length()
        def testStringLength = testString.length()

        int[][] distance = new int[referenceStringLenght + 1][testStringLength + 1]
        (referenceStringLenght + 1).times { distance[it][0] = it }
        (testStringLength + 1).times { distance[0][it] = it }
        (1..referenceStringLenght).each { i ->
            (1..testStringLength).each { j ->
              distance[i][j] = [distance[i-1][j]+1, distance[i][j-1]+1, referenceString[i-1]==testString[j-1]?distance[i-1][j-1]:distance[i-1][j-1]+1].min()
            }
        }
        distance[referenceStringLenght][testStringLength]
    }
}
