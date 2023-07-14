/* Java program to simplify a Unix
styled absolute path of a file */
import java.util.*;

class GFG
{
    public static void main(String []args)
    {
        // absolute path which we have to simplify.
        String str = "/a/./b/../../c/";
        String res = simplify(str);
        System.out.println(res);
    }

    // function to simplify a Unix - styled
    // absolute path
    static String simplify(String A)
    {
        // Stack to store the file's names.
        Stack<String> st = new Stack<>();

        // temporary String which stores the extracted
        // directory name or commands("." / "..")
        // Eg. "/a/b/../."

        // contains resultant simplifies String.
        StringBuilder res = new StringBuilder();

        // every String starts from root directory.
        res.append("/");

        // stores length of input String.
        int len_A = A.length();

        for (int i = 0; i < len_A; i++)
        {

            // we will clear the temporary String
            // every time to accommodate new directory
            // name or command.
            // dir will contain "a", "b", "..", ".";
            StringBuilder dir = new StringBuilder();

            // skip all the multiple '/' Eg. "/////""
            while (i < len_A && A.charAt(i) == '/')
                i++;

            // stores directory's name("a", "b" etc.)
            // or commands("."/"..") into dir
            while (i < len_A && A.charAt(i) != '/')
            {
                dir.append(A.charAt(i));
                i++;
            }

            // if dir has ".." just pop the topmost
            // element if the Stack is not empty
            // otherwise ignore.
            if (dir.toString().equals(".."))
            {
                if (!st.empty())
                    st.pop();
            }

            // if dir has "." then simply continue
            // with the process.
            else if (dir.toString().equals(".")) {
            }

                // pushes if it encounters directory's
                // name("a", "b").
            else if (dir.length() != 0)
                st.push(dir.toString());
        }

        // a temporary Stack (st1) which will contain
        // the reverse of original Stack(st).
        Stack<String> st1 = new Stack<>();
        while (!st.empty())
        {

            st1.push(st.pop());
            // st.pop();
        }


        // the st1 will contain the actual res.
        while (!st1.empty())
        {

            // if it's the last element no need
            // to append "/"
            if (st1.size() != 1)
                res.append(st1.pop()).append("/");
            else
                res.append(st1.pop());

            // st1.pop();
        }
        return res.toString();
    }

}

// This code is contributed by ankush_953

