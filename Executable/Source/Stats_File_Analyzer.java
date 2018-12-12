//Java program to count the 
//number of charaters in a file 
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
//import java.util.Map.Entry;

import javax.swing.*;
import javax.swing.plaf.basic.BasicTabbedPaneUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Stats_File_Analyzer
{
	//Variable to calculate the various statistics
	String line, file, s1;
	static String fileName;
	static int countWord = 0;
    static int sentenceCount = 0;
    static int characterCount = 0;
    static int paragraphCount = 1;
    static int whitespaceCount = 0;
    static String repeatedWord = null; 
    static int avgChr, mostcommonwordcount;
	static int avgwrd, count = 0;
    
	//Varaible to keep track of the history of the statistics to calculate the average
	static int histcountWord = 0;
    static int histsentenceCount = 0;
    static int histcharacterCount = 0;
    static int histparagraphCount = 0;
    static int histwhitespaceCount = 0;
    static int histavgChr;
	static int histavgwrd;
	static String fileHistory = "";
	
	//Constructor when given a file path
    Stats_File_Analyzer(String filePath){
    	
    	 	fileName = filePath.substring(filePath.lastIndexOf("/") + 1);
    	 	count++;
    		
    		wordCount(filePath);
    		paragraphCount(filePath);
	    	sentenceCount(filePath);
	    	characterCount(filePath);
	    	whitespaceCount();
	    	avgCharPl();
	    	avgWordL();
    		repeatedWord = mostRepeatedWord(filePath);
    		history();
    		output();
    		flush();
    }
    
    //constructor when the text is directly given
    Stats_File_Analyzer(String s1, int a){
    	
    		count++;
   	 
	    	this.s1 = new String(s1);
	    	wordCountTxt(s1);
	    	sentenceCountTxt(s1);
	    	characterCountTxt(s1);
	    	whitespaceCountTxt();
	    	avgCharPlTxt();
	    	avgWordLTxt();
	    	history();
	    	output();
	    	flush();
    }
    
    
    //Returns the word count in text box
    public int wordCountTxt(String s1)
    {
    	   int wordcount1 = 0;
  
    		if(!(s1.equals("")))
    		{
    			// \\s+ is the space delimiter in java
    			String[] wordList = s1.split("\\s+");
    			wordcount1 += wordList.length;
    			 countWord = wordcount1;
    		}
    		
    		return wordcount1;
    }

    //Returns the sentence count in text box
    public int sentenceCountTxt (String s1)
    {
    	   int sc1 = 0;
    	
    	   String[] sentenceList = s1.split("[!?.:]+");
    	   sc1 += sentenceList.length;
    	   sentenceCount = sc1;
    		
        return sc1;
    }

    	//Returns the total character count in text box
    public int characterCountTxt (String s1)
    {
    	   int cc1 = 0;
    	   
    	   if(!(s1.equals("")))
    	   {
    		   // \\s+ is the space delimiter in java
    		   String[] wordList = s1.split("\\s+");
    		   countWord += wordList.length;
    		   for (String word : wordList)
    		   {
    			   cc1 += word.length();
    		   }
    	   }
    		
    	   characterCount = cc1;
       return cc1;
    }


  //Returns the whitespace count in text box
    public int whitespaceCountTxt ()
    {
    	   int wsc1;
    	 	int x = wordCountTxt(this.s1);
    	 	wsc1 = x-1;
    	 	whitespaceCount = wsc1;
    	 	return wsc1;
    }

  //Returns the average character count in text box
    public int avgCharPlTxt()
    {
    	   int avgChr1;
    	 	int x = characterCountTxt(this.s1);
    	 	int y = sentenceCountTxt(this.s1);
    	 
    	 	avgChr1 = x/y;
    	 	avgChr = avgChr1;
    	 	return avgChr1;
    }

  //Returns the total word count in text box
    public int avgWordLTxt()
    {
    	   int avgwrd1;
    	 	int x = characterCountTxt(this.s1);
    	 	int y = wordCountTxt(this.s1);
    	 	
    	 	avgwrd1 = x/y;
    	 	avgwrd = avgwrd1;
    	 	return avgwrd1;
    }
    
    //Returns the word count in file
    public int wordCount(String fp)
    {
   	   int wordcount1 = 0;
   	 	FileInputStream fileStream = null;
   			try {
   				fileStream = new FileInputStream(fp);
   			} catch (FileNotFoundException e) {
   				// TODO Auto-generated catch block
   				e.printStackTrace();
   			}
       InputStreamReader input = new InputStreamReader(fileStream);
       BufferedReader reader = new BufferedReader(input);
       try {
   			while((line = reader.readLine()) != null)
   			{
   					if(!(line.equals("")))
   					{
   			      
   			     //characterCount += line.length();
   			      
   			     // \\s+ is the space delimiter in java
   			     String[] wordList = line.split("\\s+");
   			     wordcount1 += wordList.length;
   			     countWord = wordcount1;
   					}
   			 }
   		} catch (IOException e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   		}
        return wordcount1;
    }
    
    public int paragraphCount(String fp)
    {
   	   int pc1 = 0;
   	 	 file = fp;
   	 	FileInputStream fileStream = null;
   			try {
   				fileStream = new FileInputStream(fp);
   			} catch (FileNotFoundException e) {
   				// TODO Auto-generated catch block
   				e.printStackTrace();
   			}
        InputStreamReader input = new InputStreamReader(fileStream);
        BufferedReader reader = new BufferedReader(input);
        try {
   			while((line = reader.readLine()) != null)
   			 {
   				 //String[] words = line.split(" ");
   				 
   			     if(line.equals(""))
   			     {
   			         pc1++;
   			     }
   			     pc1 = paragraphCount;
   			 }
   		} catch (IOException e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   		}
        return pc1;
    }
    
  //Returns the sentence count in file
    public int sentenceCount (String fp)
    {
   	   int sc1 = 0;
   	 FileInputStream fileStream = null;
   		try {
   			fileStream = new FileInputStream(fp);
   		} catch (FileNotFoundException e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   		}
        InputStreamReader input = new InputStreamReader(fileStream);
        BufferedReader reader = new BufferedReader(input);
        try {
   			while((line = reader.readLine()) != null)
   			 {
   				 String[] sentenceList = line.split("[!?.:]+");
   			     sc1 += sentenceList.length;
   			     sentenceCount = sc1;
   			 }
   		} catch (IOException e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   		}
        return sc1;
    }
    
  //Returns the character count in file
    public int characterCount (String fp)
    {
   	   int cc1 = 0;
   	 	FileInputStream fileStream = null;
   			try {
   				fileStream = new FileInputStream(fp);
   			} catch (FileNotFoundException e) {
   				// TODO Auto-generated catch block
   				e.printStackTrace();
   			}
        InputStreamReader input = new InputStreamReader(fileStream);
        BufferedReader reader = new BufferedReader(input);
        try {
   			while((line = reader.readLine()) != null)
   			 {
   			     if(!(line.equals("")))
   			     {
   			          
   			         //characterCount += line.length();
   			          
   			         // \\s+ is the space delimiter in java
   			         String[] wordList = line.split("\\s+");
   			         countWord += wordList.length;
   			         for (String word : wordList)
   			         {
   			        	 cc1 += word.length();
   			         }
   			     }
   			     characterCount = cc1;
   			 }
   		} catch (IOException e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   		}
        return cc1;
    }
    
  //Returns the blank space count in file
    public int whitespaceCount ()
    {
   	   int wsc1;
   	 	int x = wordCount(file);
   	 	wsc1 = x-1;
   	 	whitespaceCount = wsc1;
   	 	return wsc1;
    }
    
  //Returns the average character count in file
    public int avgCharPl()
    {
   	   int avgChr1;
   	 	int x = characterCount(file);
   	 	int y = sentenceCount(file);
   	 
   	 	avgChr1 = x/y;
   	 	avgChr = avgChr1;
   	 	return avgChr1;
    }
    
  //Returns the average word count in file
    public int avgWordL()
    {
   	   int avgwrd1;
   	 	int x = characterCount(file);
   	 	int y = wordCount(file);
   	 	
   	 	avgwrd1 = x/y;
   	 	avgwrd = avgwrd1;
   	 	return avgwrd1;
    }
    
  //Returns the most commonly used word in file
    public String mostRepeatedWord(String fp) 
   	    {    
   	        //Creating wordCountMap which holds words as keys and their occurrences as values
   	         
   	        HashMap<String, Integer> wordCountMap = new HashMap<String, Integer>();
   	     
   	        BufferedReader reader = null;
   	        String mostRepeatedWord = null;
   	         
   	        try
   	        {
   	            //Creating BufferedReader object
   	             
   	            reader = new BufferedReader(new FileReader(fp));
   	             
   	            //Reading the first line into currentLine
   	             
   	            String currentLine = reader.readLine();
   	             
   	            while (currentLine != null)
   	            {    
   	                //splitting the currentLine into words
   	                 
   	                String[] words = currentLine.toLowerCase().split(" ");
   	                 
   	                //Iterating each word
   	                 
   	                for (String word : words)
   	                {
   	                    //if word is already present in wordCountMap, updating its count
   	                     
   	                    if(wordCountMap.containsKey(word))
   	                    {    
   	                        wordCountMap.put(word, wordCountMap.get(word)+1);
   	                    }
   	                     
   	                    //otherwise inserting the word as key and 1 as its value
   	                    else
   	                    {
   	                        wordCountMap.put(word, 1);
   	                    }
   	                }
   	                 
   	                //Reading next line into currentLine
   	                 
   	                currentLine = reader.readLine();
   	            }
   	             
   	            //Getting the most repeated word and its occurrence
   	             
   	            //String mostRepeatedWord = null;
   	             
   	            int count = 0;
   	             
   	            Set<Map.Entry<String, Integer>> entrySet = wordCountMap.entrySet();
   	             
   	            for (Map.Entry<String, Integer> entry : entrySet)
   	            {
   	                if(entry.getValue() > count)
   	                {
   	                    mostRepeatedWord = entry.getKey();
   	                     
   	                    count = entry.getValue();
   	                }
   	            }
   	             
   	         mostcommonwordcount = count;
   	            return mostRepeatedWord;
   	        } 
   	        catch (IOException e) 
   	        {
   	            e.printStackTrace();
   	        }
   	        finally
   	        {
   	            try
   	            {
   	                reader.close();           //Closing the reader
   	            }
   	            catch (IOException e) 
   	            {
   	                e.printStackTrace();
   	            }
   	        }
   	        return mostRepeatedWord;
   	        
   	    } 
    
     //Removes the data from the variable to get the new values on the next run. 
     public void flush () {
     
    	 	countWord = 0;
    	 	sentenceCount = 0;
    	 	characterCount = 0;
    	 	paragraphCount = 1;
    	 	whitespaceCount = 0;
    	 	repeatedWord =null; 
    	 	avgChr= 0;
 		avgwrd = 0;
 		fileName = null;
     }
     
     //Stores the statistics of the previous data to give the average
     public void history () {
    	 
    	  	histcountWord = (histcountWord + countWord) / count;
    	    histsentenceCount = (histsentenceCount + sentenceCount) / count;
    	    histcharacterCount = (histcharacterCount + characterCount) / count;
    	    histparagraphCount = (histparagraphCount + paragraphCount) / count;
    	    histwhitespaceCount = (histwhitespaceCount + whitespaceCount) / count;  
    	    histavgwrd = (histavgwrd + avgwrd) / count;
    	    
    	    //To avoid storing the file details when the input is given through text box
    	    if (fileName != null)
    	    {
    	    		String fileTime = new SimpleDateFormat("yyyy-MM-dd  HH:mm").format(new Date());
    	    		fileHistory = fileHistory +">> " +fileName + "-----------------------" + fileTime+"\n";
    	    }
     }
     
     public static void output ( ) {
 		
    	 	//Main output frame design
 		JFrame outputFrame = new JFrame("Statistics");
 		outputFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
 		outputFrame.setBounds(500, 500, 300, 300);
 		outputFrame.setSize(600, 400);
 		
 		//Label for the main output  
 		JLabel outputLabel = new JLabel("  Result");
 		outputLabel.setFont(new Font(outputLabel.getFont().getName(), outputLabel.getFont().getStyle(), 30));
 		
 		JPanel outputPanel = new JPanel();
 		outputPanel.setLayout(new BorderLayout());	
 		outputPanel.add(BorderLayout.NORTH, outputLabel);
 		
 		//Results to be displayed in the output tab.
 		JLabel dataLabel = new JLabel("<html><br>No. of Lines : "+Integer.toString(sentenceCount)+"<html><br><br>No. of Blank spaces : "+Integer.toString(whitespaceCount)+
 				 "<html><br><br>Total no. of paragraph : "+Integer.toString(paragraphCount)+ "<html><br><br>Total no. of words : "+Integer.toString(countWord)+
 				 "<html><br><br>No of Characters : "+Integer.toString(characterCount)+"<html><br><br>Average characters per line : "+Integer.toString(avgChr)+"<html><br><br>Average word length : "+Integer.toString(avgwrd)+
 				 "<html><br><br>Most common word : "+repeatedWord+"<html><br><br>Most common word count : "+Integer.toString(mostcommonwordcount)+"<html><br><br> ");
 		
 		dataLabel.setHorizontalAlignment(JLabel.CENTER);
 		
 		//Panel for the output date
 		JPanel dataPanel = new JPanel();
 		dataPanel.setLayout(new BorderLayout());
 		dataPanel.add(dataLabel, BorderLayout.CENTER);
 		
 		//Buttons for options
 		JButton help = new JButton ("Help");
 		JButton ok = new JButton ("OK");
 		
 		//Panel to add buttons
 		JPanel buttonPanel = new JPanel();
 		buttonPanel.add(help, BorderLayout.EAST);
 		buttonPanel.add(ok, BorderLayout.WEST);
 		
 		
 		//Action to close the frame on clicking on the button ok
 		ok.addActionListener(new ActionListener()
 		{

 			@Override
 			public void actionPerformed(ActionEvent e) {
 				// TODO Auto-generated method stub
 				outputFrame.dispose();
 			}
 		});
 		
 		//Action to display the details on clicking the help button
 		help.addActionListener(new ActionListener()
 		{

 			@Override
 			public void actionPerformed(ActionEvent e) {
 				
 				try{
 					
 					JFrame helpFrame = new JFrame("Statistics");
 					helpFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
 					helpFrame.setBounds(500, 500, 300, 300);
 					helpFrame.setSize(600, 400);
 					
 					JLabel helpLabel = new JLabel ("<html> The result displayed is the statistics of the file/text processed , there are 3 tabs,<br><br>" 
 							+ 
 							"<html>Output – Contains the results of the current file/text being processed.<br>" + 
 							"<html>Average – Contains the average result of all the file files processed till now.<br>" + 
 							"<html>History – Details of the files processed till now.<br><br>" + 
 							"<html>Details of the values,<br>"+ 
 							"<html>No. of Lines – The total number of lines in the content.<br>" + 
 							"<html>No. of Blank Lines – The total blank spaces between the paragraphs.<br>" + 
 							"<html>Total no. of paragraph – The total number of paragraphs in the content.<br>" + 
 							"<html>Total no. of words – Total number of words in the content.<br>" + 
 							"<html>Average characters per length – The number of characters in a word <br>" + 
 							"<html>Average word length – Average length of the words<br>" + 
 							"<html>Most common word – The most commonly used word in the content.");
 					
 					helpLabel.setHorizontalAlignment(JLabel.CENTER);
 					helpFrame.add(helpLabel);
 					helpFrame.setVisible(true);
 					

 			        }

 			      	catch (Exception ex) {
 			        ex.printStackTrace();
 			      }
 				
 				}
 		});
 		
 		//Details of the average of the statistics collected so far.
 		JLabel historyLabel = new JLabel("<html><br>Average no. of Lines : "+Integer.toString(histsentenceCount)+"<html><br><br>Average no. of Blank Lines : "+Integer.toString(histwhitespaceCount)+
				 "<html><br><br>Average no. of paragraph : "+Integer.toString(histparagraphCount)+ "<html><br><br>Average no. of words : "+Integer.toString(histcountWord)+
				 "<html><br><br>Average characters : "+Integer.toString(histcharacterCount)+"<html><br><br>Average characters per line : "+Integer.toString(histavgChr)+"<html><br><br>Average word length : "+Integer.toString(histavgwrd)
				 +"<html><br><br>Total no of files processed : "+Integer.toString(count));
 		
 		historyLabel.setHorizontalAlignment(JLabel.CENTER);
 		String formattedResponse = fileHistory.replaceAll("\n", "<br />");
 		JLabel fileHistoryLabel = new JLabel ("<html>"+formattedResponse);
 		fileHistoryLabel.setHorizontalAlignment(JLabel.CENTER);
 		
 		//Panel for each tab in the output frame
 		JPanel comprehensivePanel = new JPanel();
 		JPanel averagePanel = new JPanel();
 		JScrollPane fileHistPanel = new JScrollPane();
 		
 		comprehensivePanel.setLayout(new BorderLayout());
 		averagePanel.setLayout(new BorderLayout());
 		
 		//Main output details added in the first tab panel
 		comprehensivePanel.add(outputPanel, BorderLayout.NORTH);
 		comprehensivePanel.add(dataLabel, BorderLayout.CENTER);
 		comprehensivePanel.add(buttonPanel, BorderLayout.AFTER_LAST_LINE);
 		
 		//Average statistics details added to the second tab average panel.
 		averagePanel.add(historyLabel, BorderLayout.CENTER);
 		
 		//History of file processed details added to the history panel.
 		fileHistPanel.setViewportView(fileHistoryLabel);
 		
 		//New tab panel created to add each panel in a tab.
 		JTabbedPane tabPane = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);
 		
 		tabPane.setUI(new BasicTabbedPaneUI() {
 	        @Override
 	        protected int calculateTabWidth(
 	                int tabPlacement, int tabIndex, FontMetrics metrics) {
 	            return 200; // the width of the tab
 	        }
 	    });
 		
 		//output panels are added to the tab pane
 		tabPane.addTab("Output", comprehensivePanel);
 		tabPane.addTab("Average", averagePanel);
 		tabPane.addTab("History", fileHistPanel);
 		outputFrame.getContentPane().add(tabPane, BorderLayout.CENTER);
 		
 		outputFrame.setVisible(true);
 	}
 
}

