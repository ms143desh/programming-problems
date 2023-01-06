package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MostPopularVideoCreator2456 {
    public static void main(String[] args) {
        MostPopularVideoCreator2456 mostPopularVideoCreator2456 = new MostPopularVideoCreator2456();
        System.out.println(mostPopularVideoCreator2456.mostPopularCreator(new String[]{"alice","bob","alice","chris"}, new String[]{"one","two","three","four"}, new int[]{5,10,5,4}));
        System.out.println(mostPopularVideoCreator2456.mostPopularCreator(new String[]{"alice","alice","alice"}, new String[]{"a","b","c"}, new int[]{1,2,2}));
        System.out.println(mostPopularVideoCreator2456.mostPopularCreator(new String[]{"a"}, new String[]{"a"}, new int[]{0}));
        System.out.println(mostPopularVideoCreator2456.mostPopularCreator(new String[]{"ba", "ba"}, new String[]{"aaa", "a"}, new int[]{1, 1}));
    }

    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        Map<String, List<Integer>> creatorsViewsMap = new HashMap<>();
        Map<String, List<String>> creatorsIdsMap = new HashMap<>();
        Map<String, Integer> creatorsViewCountMap = new HashMap<>();
        List<List<String>> output = new ArrayList<>();
        int maxCount = 0;
        for(int i=0;i<creators.length;i++) {
            List<Integer> cViewsList = creatorsViewsMap.getOrDefault(creators[i], new ArrayList<>());
            List<String> cIdsList = creatorsIdsMap.getOrDefault(creators[i], new ArrayList<>());
            int creatorViewCount = creatorsViewCountMap.getOrDefault(creators[i], 0);

            if(creatorViewCount + views[i] > maxCount) {
                maxCount = creatorViewCount + views[i];
            }
            cViewsList.add(views[i]);
            creatorsViewsMap.put(creators[i], cViewsList);
            cIdsList.add(ids[i]);
            creatorsIdsMap.put(creators[i], cIdsList);
            creatorsViewCountMap.put(creators[i], creatorViewCount + views[i]);
        }

        Set<String> creatorSet = creatorsViewCountMap.keySet();
        Iterator<String> itr = creatorSet.iterator();

        while(itr.hasNext()) {
            String creator = itr.next();
            if(creatorsViewCountMap.get(creator) == maxCount) {
                List<Integer> cViewsList = creatorsViewsMap.get(creator);
                List<String> cIdsList = creatorsIdsMap.get(creator);
                int maxViews = 0, index = 0;
                for(int i=0;i<cViewsList.size();i++) {
                    if((cViewsList.get(i) > maxViews) || (cViewsList.get(i) == maxViews && cIdsList.get(i).compareTo(cIdsList.get(index)) < 0)) {
                        index = i;
                        maxViews = cViewsList.get(i);
                    }
                }
                List<String> outputSubList = new ArrayList<>();
                outputSubList.add(creator);
                outputSubList.add(cIdsList.get(index));
                output.add(outputSubList);
            }
        }
        return output;
    }
}
