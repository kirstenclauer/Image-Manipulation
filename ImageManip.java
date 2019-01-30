public class ImageManip {

	private int[][] originalImage = new int[5][6]; 
	private int[][] blurredImage = new int[5][6];
	
	public ImageManip(int[][] array) {
		
		for(int row = 0; row < array.length; row++) {
			for(int col = 0; col < array[row].length; col++) {
				originalImage[row][col] = array[row][col];
				blurredImage[row][col] = array[row][col]; 
			}
			
		}
	}
	
	private int averageNeighbors(int row, int col) {
		int average = blurredImage[row][col];
		if(col == 5) {
			
		} else {
		average = (originalImage[row - 1][col - 1] + originalImage[row - 1][col] + originalImage[row - 1][col + 1] +
		originalImage[row][col - 1] + originalImage[row][col] + originalImage[row][col + 1] + originalImage[row + 1][col - 1] +
		originalImage[row + 1][col] + originalImage[row + 1][col + 1]) /9;
		}
		return average; 
	}
	
	public void blurImage() {
		
		for(int row = 1; row < originalImage.length - 1; row++) {
			for(int col = 1; col < originalImage[row].length; col++) {
				
				blurredImage[row][col] = averageNeighbors(row,col);
			}
		}
	} 
	
	public String originalImage() {	
		String originalImageTable = "\n"; 
		for(int row = 0; row < originalImage.length; row++) {
			for(int col = 0; col < originalImage[row].length; col++) {
				if(col == originalImage.length) {
				originalImageTable = originalImageTable.concat(Integer.toString(originalImage[row][col])) + "\n";
				} else {
				originalImageTable = originalImageTable.concat(Integer.toString(originalImage[row][col])) + "\t";
				}
			}
		}
		return originalImageTable; 
	}
	
	public String blurredImage() {	
		String blurredImageTable = "\n"; 
		for(int row = 0; row < blurredImage.length; row++) {
			for(int col = 0; col < blurredImage[row].length; col++) {
				if(col == blurredImage.length) {
					blurredImageTable = blurredImageTable.concat(Integer.toString(blurredImage[row][col])) + "\n";
					} else {
					blurredImageTable = blurredImageTable.concat(Integer.toString(blurredImage[row][col])) + "\t";
					}
			}
		}
		return blurredImageTable; 
	}
	
	public static void main(String[] args) {
		int[][] data = {{78, 89, 122, 133, 145, 189},
						{84, 91, 125, 135, 158, 200},
						{95, 98, 140, 145, 178, 210},
						{111, 121, 148, 160, 189, 225},
						{134, 146, 156, 187, 199, 230}}; 
		
		ImageManip image = new ImageManip(data); 
		
		System.out.println("The original image is " + image.originalImage());
		image.blurImage(); 
		System.out.println("The blurred image is " + image.blurredImage());
	}
	
}