package com.example.demo.util

class CommonUtil {

    /**
     * @param   path
     * @return  map
     * @sample  path = "/usr/local/documents/Test.kt"
     *  return  directory : '/usr/local/documents'
     *          fullName :  'Test.kt'
     *          fileName :  'Test'
     *          extension : 'kt'
     */
    fun pathUtil(path:String): Map<String, String>{
        val directory = path.substringBeforeLast("/") // directory - 전체 경로의 첫 글자부터 마지막 슬래시 바로 전까지
        val fullName = path.substringAfterLast("/") // 파일 풀네임
        val fileName = fullName.substringBeforeLast(".") // 파일명
        val extension = fullName.substringAfterLast(".") // 확장자
        val pathMap = hashMapOf("directory" to directory, "fullName" to fullName, "fileName" to fileName, "extension" to extension)
        return pathMap
    }

    /**
     * @param   separator, prefix, postfix
     * @return  String
     * @sample  separator: ";" / prefix : "(" / postfix : ")"
     *          listOf("one", "two", "three")
     * return   (one; two; three;)
     */
    fun <T> Collection<T>.joinToString(
        separator:String = ", ",
        prefix:String = "",
        postfix:String = ""
    ): String {
        val result = StringBuilder(prefix)
        for((index, element) in this.withIndex()){
            if(index > 0) result.append(separator)
            result.append(element)
        }
        result.append(postfix)
        return result.toString()
    }
}