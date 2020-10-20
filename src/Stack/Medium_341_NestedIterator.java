package Stack;

import java.util.*;

/**
 * Iterator包含三个方法：hasNext ,  next , remove
 *  1、每次在迭代前   ，先调用hasNext()探测是否迭代到终点（本次还能再迭代吗？）。
 * 2、next方法不仅要返回当前元素，还要后移游标cursor
 * 3、remove()方法用来删除最近一次已经迭代出的元素
 * 4、 迭代出的元素是原集合中元素的拷贝（重要）
 * 5、配合foreach使用
 */

/**
 * 这道题不会
 */
public class Medium_341_NestedIterator{
}

//class NestedIterator implements Iterator<Integer> {
//    List<Integer> list = new ArrayList<>();
//    ListIterator<Integer> it;
//
//    public NestedIterator(List<NestedInteger> nestedList) {
//        dfs(nestedList);
//        it = list.listIterator();
//    }
//
//    @Override
//    public Integer next() {
//        return it.next();
//    }
//
//    @Override
//    public boolean hasNext() {
//        return it.hasNext();
//    }
//
//    private void dfs(List<NestedInteger> nestedList){
//        for (NestedInteger nestedinteger: nestedList) {
//            if (nestedinteger.isInteger()) {
//                list.add(nestedinteger.getInteger());
//            } else {
//                dfs(nestedinteger.getList());
//            }
//        }
//    }
//}


//class NestedIterator implements Iterator<Integer> {
//    Deque<NestedInteger> stack = new ArrayDeque<>();
//
//    public NestedIterator(List<NestedInteger> nestedList) {
//        for (int i = nestedList.size(); i >= 0; --i) {
//            stack.offerFirst(nestedList.get(i));
//        }
//    }
//
//    @Override
//    public Integer next() {
//        return stack.pollFirst().getInteger();
//    }
//
//    @Override
//    public boolean hasNext() {
//        if (stack.isEmpty()) {
//            return false;
//        } else {
//            if (!stack.peekFirst().isInteger()){
//                List<NestedInteger> ni = stack.pollFirst().getList();
//                for (int i = ni.size() - 1; i >= 0; --i) {
//                    stack.offerFirst(ni.get(i));
//                }
//                return hasNext();
//            }else {
//                return true;
//            }
//        }
//    }
//}


