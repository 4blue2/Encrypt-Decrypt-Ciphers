public class Caesar{

    static char[] low_alph = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    static char[] up_alph = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    public static char rotate(int shift, char ch){

        char rot_ch = ch;
        int position = 0;
        int new_position = 0;
        boolean found = false;
        boolean capital_letter = false;
        int i = 0;

        //find teh position of the character to be rotated in the alphabet 
        while(found == false && i < low_alph.length){

            if(ch == low_alph[i]){

                position = i;
                found = true;

            }else if(ch == up_alph[i]){
            
                position = i;
                found = true;
                capital_letter = true;

            }

            i++;
            
        }
        
        if (found == false){    
            return rot_ch; //other characters remain untouched
        }
        
        if(shift > 0 && position + shift < 25){ 

            new_position = position + shift;

        }else if(shift > 0 && position + shift > 25){ // 25 here is the position in the array

            new_position = ((position + shift) % 26) - 1; //26 number of letters. -1 because positions start from 0

        }else if(shift < 0 && position + shift > 0){

            new_position = position + shift;

        }else if(shift < 0 && position + shift < 0){

            new_position = ((position + shift) % 26) + 26;

        }else{
            System.out.println("Error.");
        }

        if(capital_letter == true){
            rot_ch = up_alph[new_position];
        }else{
            rot_ch = low_alph[new_position];
        }

        return rot_ch;
    }

    public static void main(String[] args){

        char x = rotate(36, '$');

        System.out.println(x);

    }
}