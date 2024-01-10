import java.util.*;
import java.util.stream.*;
class Solution {
    public String[] solution(String[] todo_list, boolean[] finished) {
        List<String> unfinishedTasks = Arrays.stream(todo_list)
                .filter(task -> {
                    int index = Arrays.asList(todo_list).indexOf(task);
                    return index < finished.length && !finished[index];
                })
                .collect(Collectors.toList());

        return unfinishedTasks.toArray(new String[0]);
    }
}