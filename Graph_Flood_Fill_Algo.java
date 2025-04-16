
public class Graph_Flood_Fill_Algo {
    
    public static void helper(int [][]images,int sr,int sc,int color,boolean isVisit[][],int orgCol){
        if(sr<0||sc<0||sr>=images.length||sc>=images[0].length||isVisit[sr][sc]||images[sr][sc]!=orgCol){
            return;

        }
        images[sr][sc]=color;
        isVisit[sr][sc]=true;
        helper(images, sr, sc-1, color, isVisit, orgCol);
        helper(images, sr, sc+1, color, isVisit, orgCol);
        helper(images, sr-1, sc, color, isVisit, orgCol);
        helper(images, sr+1, sc, color, isVisit, orgCol);

    }
    public int [][] floodfill(int [][] images,int sr,int sc,int color){
        boolean isVisit[][]=new boolean[images.length][images[0].length];
        if(images[sr][sc]!=color){
            helper(images, sr, sc, color, isVisit, images[sr][sc]);

        }
        return images;
    }
    public static void main(String[] args) {
        int[][] image = {
            {1, 1, 1},
            {1, 1, 0},
            {1, 0, 1},
            
        };

        int sr = 1, sc = 1, newColor = 2;

        Graph_Flood_Fill_Algo floodFillAlgo = new Graph_Flood_Fill_Algo();
        
        int[][] filledImage = floodFillAlgo.floodfill(image, sr, sc, newColor);

        System.out.println("Filled Image:");
for (int i = 0; i < filledImage.length; i++) { // Loop through each row
    for (int j = 0; j < filledImage[i].length; j++) { // Loop through each pixel in the row
        System.out.print(filledImage[i][j] + " "); // Print the pixel
    }
    System.out.println(); // Print a new line after each row
}
    }

}
