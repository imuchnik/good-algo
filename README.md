
Cool algoritmical problem solved with Trie data structure

To run: 
 1. Clone repo
 2. cd into the folder
 3. run "grails run-app" command
 4. Look at the under good_homework folder


###Instructions

Your project is to build a website that allows users to lookup information about vehicles by entering a Vehicle Serial Number (VSN)[1] The site should validate the VSN for proper formatting, and display the user a set of matched results, if any.

Attached is a csv file with the format: 
VSN Pattern, Vehicle Trim Id, Year, Make, Model, Trim Name

Use the following rules to match VSNs:
 * Valid VSNs are in the format of six letters (A-Z) followed by six numbers (0-9)
 * VSN patterns contain exact-match characters (A-Z and 0-9) and wildcard characters (*). Any character of the valid type (as defined in #1) will match against a wildcard character
 * If multiple patterns match the input, use the pattern that has more exact-match characters

Examples:
```
Pattern: "ABC*EF*****6" matches against "ABCAEF111116", but not "ABC1EFAAAAA6"
If there are two patterns: "ABCDEF******" and "ABCDEF1*****", the string "ABCDEF123456" would match against the second pattern because it has fewer asterisks.
```
At a minimum, the user interface should provide an input box to allow entry of the serial number, and a button to submit. If the serial number is invalid (does not match rule #1 above), show an error message to the user.

This page can be very basic. It does not need any other special formatting other than to be valid, well-structured HTML (unless you feel like snazzing it up =).

Write this website using using the language/framework of your choice, and feel free to use any third-party CSS or JS libraries.


Finally, while the VSN input set is relatively small, in a real-world environment the list will be much larger. If your solution would not adequately perform with tens or hundreds of thousands of VSN search patterns, please describe how you would build a solution to handle that in a readme file. The readme should also include any special installation requirements, known issues, areas for improvement, ideas for version 2, etc.
 Have fun!


[1] VSN is a made-up term, but is similar to how Vehicle Identification Numbers (VIN) work.
