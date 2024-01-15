class Solution {
    StringBuilder sb = new StringBuilder();
    String[] result;
    String[] row,col;
    String[] pic;
    public String[] solution(String[] picture, int k) {
        pic = picture;
        result = new String[picture.length * k];
        row = new String[picture.length];
        col = new String[picture.length * k];
        
        rowSpan(k);
        colSpan(k);
        
        return col;
        
    }
    
    public void rowSpan(int k){
        for(int i = 0; i < pic.length; i++){
            sb = new StringBuilder();
            for(int j = 0; j < pic[0].length(); j++){
                for(int l = 0; l < k; l++){
                    sb.append(pic[i].charAt(j));    
                }
            }
            row[i] = sb.toString();
        }
    }
    
    public void colSpan(int k){
        sb = new StringBuilder();
        int idx = 0;
        
        while(idx < row.length){
            for(int i = idx * k; i < idx * k + k; i++){
                col[i] = row[idx];
            }
            idx++;
        }
    }
}