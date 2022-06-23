package com.ummaaack.coding_test.baekjoon_step

class Solution {
    fun solution(s: String): Int {
        var st=s
        var answer: Int = 0
        var realString=""
        //1zerotwozero3  one4seveneight
        for(index in st.indices){


            if(index==st.length-1&&st[st.length-1].isDigit()) {
                realString=realString+"${st[index]}"
                return realString.toInt()
                break}

            (0..9).forEachIndexed{index,i->

            }
            if(index==st.length-1&&!st[st.length-1].isDigit()) {

                return realString.toInt()
                break}


            //숫자라면
            if(st[index].isDigit()){
                realString=realString+"${st[index]}" //하나씩 붙임
            }

            if(!st[index].isDigit()){  //숫자가 아니라면
                //해당인덱스부터 다음인덱스까지 차례대로 슬라이스하고
                var strIndex=index+1
                while(true){
                    if(strIndex==st.length) break  //끝까지 갔는데 없으면 나와라
                    var emptyString=st.substring(index..strIndex)
                    println("emptyString: "+"${emptyString}")
                    when(emptyString){

                        "zero"->{ realString=realString.plus('0')
                            println("realString:"+"${realString}")
                            break}
                        "one"->{realString=realString+"1"
                            println("realString"+"${realString}")
                            break}
                        "two"->{realString=realString+"2"
                            println("realString"+"${realString}")
                            break}
                        "three"->{realString=realString+"3"
                            println("realString"+"${realString}")
                            break}
                        "four"->{realString=realString+"4"
                            println("realString"+"${realString}")
                            break}
                        "five"->{realString=realString+"5"
                            break}
                        "six"->{realString=realString+"6"
                            break}
                        "seven"->{realString=realString+"7"
                            break}
                        "eight"->{realString=realString+"8"
                            break}
                        "nine"->{realString=realString+"9"
                            break}
                        else->{    strIndex+=1}
                    }

                }
            }
            //그게 문자와 일치하면

        }

        return answer
    }
}