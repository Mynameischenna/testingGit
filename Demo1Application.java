https://app.swaggerhub.com/apis/asdas-233/TicketBookingAPI/1.0.0#/Bookings/post_bookings

package com.example.firstt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFPicture;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFPictureData;

@SpringBootApplication
public class Demo1Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class, args);
		System.out.println("hello hsos");
}
} 


@Component
class DocxReplacementRunner implements CommandLineRunner {

    @Autowired
    private repo planInfoRepository;

    @Override
    public void run(String... args) {
        try {
            // Fetch data from the database
            List<PlanInfo> planInfoList = planInfoRepository.findAll();

            // Replace tags in the DOCX document
            replaceTagsInDocxDocument("C:\\Users\\chenn\\Downloads\\inputxml.docx", "C:\\Users\\chenn\\OneDrive\\Desktop\\outputxml.docx", planInfoList);


            System.out.println("DOCX document updated successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void replaceTagsInDocxDocument(String inputFilePath, String outputFilePath, List<PlanInfo> planInfoList) {
        try (FileInputStream fis = new FileInputStream(inputFilePath);
             XWPFDocument document = new XWPFDocument(fis)) {

            for (PlanInfo planInfo : planInfoList) {
                for (XWPFParagraph paragraph : document.getParagraphs()) {
                    for (XWPFRun run : paragraph.getRuns()) {
                        String text = run.getText(0);

                        if (text != null) {
                            // Replace XML tags with actual data
                            text = replaceXmlTagsWithData(text, planInfo);
                            run.setText(text, 0);
                        }
                    }
                }
            }

            // Save the modified document
            try (FileOutputStream fos = new FileOutputStream(outputFilePath)) {
                document.write(fos);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String replaceXmlTagsWithData(String text, PlanInfo planInfo) {
        // Replace XML tags with actual data
        text = text.replace("${EV_ID}", String.valueOf(planInfo.getEvId()));
        text = text.replace("${PLAN_NAME}", planInfo.getPlanName());
        // Add more replacements for other fields

        return text;
    }
}

//public class XMLParser {
//
//    public static void main(String[] args) {
//        
//    }
//}
