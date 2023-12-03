package org.workout.myimpl;

import java.util.HashMap;
import java.util.Objects;

/** In this example we'll try to break HashMap using
 * - The same only key value for any added entry
 * - Using as a key-class the class which doesn't implement Comparable.
 * So, let's see what happens at the moment the only bucket is being transformed from a linked list
 * to a treemap.
 *
 *  Summary: the HashMap-instance won't be broken: because of the next piece of code within HashMap class:
 *  <code>
 *       (kc = comparableClassFor(k)) == null) ||
 *                                  (dir = compareComparables(kc, k, pk)) == 0)
 *                             dir = tieBreakOrder(k, pk);
 *  </code>
 *
 *  And in the method HashMap.tieBreakOrder for comparison is the method
 *  <code>System.identityHashCode(Object o)</code>
 *  is used.
 */
public class TryToBreakHashMapUsingNotImplComparable {
    static class KeyValue  {
        String s;

        public KeyValue(int i) {
            s = Integer.toString(i);
        }

        @Override
        public String toString() {
            return "Key{" +
                    "s='" + s + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            KeyValue other = (KeyValue) o;
            return (s.equals(other.s));
        }

        @Override
        public int hashCode() {
            return Objects.hash("1");
        }
    }

    public static void workout() {
        HashMap<KeyValue, KeyValue> hashMap = new HashMap<>();

        for (int i = 0; i < 2000; i++) {
            KeyValue key = new KeyValue(i);
            System.out.println("Try to add <" + key + ", " + i + "> to our hashMap");
            System.out.println("Key.hashCode()=" + key.hashCode());
            System.out.println("Key.identityHashCode()=" + System.identityHashCode(key)); // Уникальный хеш-код для obj1
            hashMap.put(key, key);
            System.out.println("hashMap.size()=" + hashMap.size());
        }

        System.out.println("hashMap.get(new KeyValue(1000)) = " + hashMap.get(new KeyValue(1000)));
    }
}
