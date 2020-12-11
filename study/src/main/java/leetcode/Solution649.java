package leetcode;

public class Solution649 {
    public String predictPartyVictory(String senate) {
        char[] charArray = senate.toCharArray();
        if (charArray.length == 1) {
            return charArray[0] == 'R' ? "Radiant" : "Dire";
        }

        char current;
        int RNumber, DNumber, RNote, DNote, realNumber, total = charArray.length;
        while (true) {
            RNumber = 0;
            DNumber = 0;
            RNote = 0;
            DNote = 0;
            realNumber = 0;
            for (int i = 0; i < total; i++) {
                current = charArray[i];
                if (current == 'R') {
                    if (DNote > 0) {
                        DNote--;
                        continue;
                    }
                    charArray[realNumber++] = current;
                    RNumber++;
                    RNote++;
                } else {
                    if (RNote > 0) {
                        RNote--;
                        continue;
                    }
                    charArray[realNumber++] = current;
                    DNumber++;
                    DNote++;
                }
            }
            total = realNumber;
            if (RNote > 0 && DNumber > 0) {
                int tmp = 0;
                for (int j = 0; j < realNumber; j++) {
                    current = charArray[j];
                    if (current == 'D' && RNote > 0) {
                        RNote--;
                        DNumber--;
                        continue;
                    }
                    charArray[tmp++] = current;
                }
                total = tmp;
            }
            if (DNote > 0 && RNumber > 0) {
                int tmp = 0;
                for (int j = 0; j < realNumber; j++) {
                    current = charArray[j];
                    if (current == 'R' && DNote > 0) {
                        DNote--;
                        RNumber--;
                        continue;
                    }
                    charArray[tmp++] = current;
                }
                total = tmp;
            }
            if (DNumber == 0 || RNumber == 0) {
                break;
            }
        }
        return RNumber > 0 ? "Radiant" : "Dire";
    }

    public static void main(String[] args) {
        Solution649 solution649 = new Solution649();
        solution649.predictPartyVictory("RD");
    }
}