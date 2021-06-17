package mostFrequentNumberInIntervals.gitHub;

import java.util.*;

public class Solution {

    public IntervalNode[] nodes;

    public int solve(int[][] intervals) {
        fillArray_nodes(intervals);
        return find_mostFrequentValue();
    }

    public int find_mostFrequentValue() {

        Arrays.sort(nodes, (a, b) -> (a.value == b.value ? a.valuePosition - b.valuePosition : a.value - b.value));
        int maxFrequency = 0;
        int frequency = 0;
        int value = nodes[0].value;

        for (IntervalNode i_node : nodes) {

            /*
            If node is a start of interval, we increase frequency with '1'. 
            If it is an end of interval, we decrease frequency with '1'.
             */
            frequency += (i_node.valuePosition == 0 ? 1 : -1);

            if (maxFrequency < frequency) {
                maxFrequency = frequency;
                value = i_node.value;
            }
        }

        return value;
    }

    public void fillArray_nodes(int[][] intervals) {
        nodes = new IntervalNode[2 * intervals.length];
        int index = 0;
        for (int i = 0; i < intervals.length; i++) {
            nodes[index++] = new IntervalNode(intervals[i][0], 0);
            nodes[index++] = new IntervalNode(intervals[i][1], 1);
        }
    }
}

class IntervalNode {

    int value;
    /*
    'valuePosition' can be either '0' or '1'. 
    If the node is at a start of an interval, it has a value of '0'.
    If the node is at an end of an interval, it has a value of '1'.
     */
    int valuePosition;

    public IntervalNode(int value, int valuePosition) {
        this.value = value;
        this.valuePosition = valuePosition;
    }
}
