public class Solution {
    /**
     * @param codeList: The codeList
     * @param shoppingCart: The shoppingCart
     * @return: The answer
     */
    public int buyFruits(List<List<String>> codeList, List<String> shoppingCart) {
        // Write your code here
        List<String> list = new ArrayList<>();
        for (List<String> l : codeList) {
            for (String s : l) {
                list.add(s);
            }
        }
        
        if (list.size() > shoppingCart.size()) {
            return 0;
        }
        
        for (int i = 0; i + list.size() <= shoppingCart.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).equals("anything")) {
                    if (j == list.size() - 1) {
                        return 1;
                    }
                    continue;
                }
                
                if (!list.get(j).equals(shoppingCart.get(i + j))) {
                    break;
                }
                
                if (j == list.size() - 1) {
                    return 1;
                }
            }
        }
        
        return 0;
    }
}
