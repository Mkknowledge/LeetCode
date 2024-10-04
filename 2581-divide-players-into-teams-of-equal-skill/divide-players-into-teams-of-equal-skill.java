class Solution {
    public long dividePlayers(int[] skill) {
        int n = skill.length;
        int teams = n/2;
        int totalSum = 0;
        //HashMap<Integer, Integer> ferqMap = new HashMap<>();
        int freqMap[] = new int[1001];
        for (int element : skill) {
            freqMap[element]++;
            //freqMap.put(element, freqMap.getOrDefault(element, 0)+1); // Finds the frequecy of the element
            totalSum += element;
        }
        if (totalSum % teams != 0) {
            return -1;
        }
        int targetPoints = totalSum / teams;
        long res = 0;
        for (int element : skill) {
           // if (freqMap.get(element)==0) {
            if (freqMap[element] == 0) {
                continue;
            }
            //freqMap.put(element, freqMap.getOrDefault(element, 0)-1); // Finds the frequecy of the element
            freqMap[element]--;
            int partner = targetPoints - element;
            //if (!feqMap.containsKey(partner) || freqMap.get(partner)==0) {
            if(freqMap[partner]==0) {
                return -1;
            }
           // freqMap.put(partner, freqMap.get(parner)-1);
            freqMap[partner]--;
            res = res + ((long)element * (long)partner);
        }
        return res;
    }
}