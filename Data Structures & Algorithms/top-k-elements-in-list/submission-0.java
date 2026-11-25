class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // return the no. of k elements most frequently occuring duplicate
        //Time complexity O(nlogn)
        //space complexity O(n)
        /** Note important - For reference/object arrays, both Arrays.stream() and Stream.of() produce a
         * standard generic Stream<T>. (Stream.of(T...) actually calls Arrays.stream(values) under the hood.)
         * Java provides specialized primitive streams (IntStream, LongStream, DoubleStream) to avoid
         * autoboxing overhead and expose math utilities like .sum(), .average(), and .max().
         * Use Arrays.stream(arr): It has explicit overloads for int[], long[], and double[] that
         * unpack the elements into a primitive stream.Avoid Stream.of(arr) on primitive arrays:
         * Because Stream.of(T... values) expects reference types, passing an int[] treats the entire
         * array as a single Object, returning a 1-element Stream<int[]> instead of streaming the numbers
         * inside.
         * If you want a Stream<Integer> (boxed objects) from int[]:
         * Stream<Integer> boxedStream = Arrays.stream(nums).boxed();
         * Other primitive arrays like boolean[], char[], byte[], short[], and float[] do not have dedicated
         * stream classes in Java—stream them via IntStream.range(0, arr.length).mapToObj(i -> arr[i]).
        **/
        //Because int[] is a primitive array, you first need to convert it to an IntStream, box the int primitives into Integer objects (since Java Maps only store objects)
        //Collectors.counting() returns a Long by default
        //Map<Integer, Long> res = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        //// Option A: groupingBy + summingInt
        //Map<Integer, Integer> res = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(n -> 1)));
        // Option B: toMap with merge function (avoids boxing each count repeatedly) also Function.identity not imported by default can use n -> n instead 
        // Map<Integer, Integer> res = Arrays.stream(nums).boxed().collect(Collectors.toMap(n -> n, n ->1, Integer::sum));
        //normal way
        // Map<Integer, Integer> res = new HashMap<>();
//        for(int i =0; i<nums.length;i++){
//            res.put(nums[i],res.getOrDefault(nums[i], 0)+1);
//        }
        //sorted((a,b) ->Integer.compare(b.getValue(), a.getValue())) if value is primitive (decending order)
        // return res.entrySet().stream().sorted((a,b) -> b.getValue().compareTo(a.getValue())).limit(k).map(Map.Entry::getKey).mapToInt(Integer::intValue).toArray();
    

        //second approach
        //Time complexity O(nlogk)
        //space complexity O(n+k)
        // Map<Integer, Integer> count = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(n->n, Collectors.summingInt(n->1)));
        // PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) ->Integer.compare(a[0], b[0]));
        // for(Map.Entry<Integer, Integer> entry: count.entrySet()){
        //     heap.offer(new int[]{entry.getValue(), entry.getKey()});
        //     if(heap.size() > k ){
        //         heap.poll();
        //     }
        // }
        //normal way of returning
        // int[] res = new int[k];
        // for (int i = 0; i < k; i++) {
        //     res[i] = heap.poll()[1];
        // }
        // return res;

//Order: heap.stream() iterates over the underlying array of the PriorityQueue, which is in heap order (not sorted by frequency). Stream.generate(heap::poll) pops elements in ascending frequency
        // return heap.stream()
        //    .mapToInt(pair -> pair[1])
        //    .toArray();

//Stream.generate(...) creates an infinite stream. Without adding .limit(k), the stream continues to invoke heap.poll() indefinitely. Once the heap is empty, heap.poll() returns null, causing a NullPointerException
    //    return Stream.generate(heap::poll)
    //          .limit(k)
    //          .mapToInt(pair -> pair[1])
    //          .toArray();

    //Third approach
     //Time complexity O(n)
    //space complexity O(n)
    Map<Integer, Integer> count = new HashMap<>();
        List<Integer>[] freq = new List[nums.length + 1];

        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }

        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            freq[entry.getValue()].add(entry.getKey());
        }

        int[] res = new int[k];
        int index = 0;
        for (int i = freq.length - 1; i > 0 && index < k; i--) {
            for (int n : freq[i]) {
                res[index++] = n;
                if (index == k) {
                    return res;
                }
            }
        }
        return res;
    }
}
