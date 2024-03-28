//有效字母的异位词
#include <stdbool.h>

bool isAnagram(char* s, char* t) {
    int hash[26]={0};
    for(int i=0;i<strlen(s);i++){
        hash[s[i]-'a']++;
    }
    for(int j=0;j<strlen(t);j++){
        hash[t[j]-'a']--;
    }
    for(int k=0;k<26;k++){
        if(hash[k]!=0){
            return false;
        }
    }
    return true;
}