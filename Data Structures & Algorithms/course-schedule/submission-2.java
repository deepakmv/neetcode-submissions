class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> courseMap = new HashMap<>();
        int[] indegree = new int[numCourses];

        for(int i=0; i<prerequisites.length; i++) {
            if(!courseMap.containsKey(prerequisites[i][1])) {
                List<Integer> courseList = new ArrayList<>();
                courseList.add(prerequisites[i][0]);
                courseMap.put(prerequisites[i][1], courseList);
            }
            else {
                List<Integer> courseList = courseMap.get(prerequisites[i][1]);
                courseList.add(prerequisites[i][0]);
                courseMap.put(prerequisites[i][1], courseList);
            }
            indegree[prerequisites[i][0]]++;
        }
    
        Queue<Integer> qu = new LinkedList<>();

        for(int i=0; i<numCourses; i++) {
            if(!courseMap.containsKey(i)) {
                courseMap.put(i, null);
            }
            if(indegree[i] == 0) {
                qu.add(i);
            }
        }

        int completed = 0;

        while(!qu.isEmpty()) {

            int curr = qu.poll();
            completed++;

            List<Integer> courseList = courseMap.get(curr);

            if(courseList != null) {
                for(Integer course: courseList) {
                    indegree[course]--;
                    if(indegree[course] == 0) {
                        qu.add(course);
                    }
                }
            }
        }
        return completed == numCourses;
    }
}
