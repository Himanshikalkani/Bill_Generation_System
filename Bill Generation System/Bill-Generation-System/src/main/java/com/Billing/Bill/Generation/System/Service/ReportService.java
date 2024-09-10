package com.Billing.Bill.Generation.System.Service;

import com.Billing.Bill.Generation.System.Modules.Product;
import com.Billing.Bill.Generation.System.Repository.productRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ReportService {

    @Autowired
    private productRepo productRepository;

    public void generateReport(){
        List<Product> products=productRepository.findAll();

        String date=new SimpleDateFormat("dd-MM-yyyy").format(new Date());
        String filePath="D:\\Bill Generation System\\Bill-Generation-System\\src\\main\\resources\\Reports\\products_report_" + date + ".csv";

        try(ICsvBeanWriter beanWriter=new CsvBeanWriter(new FileWriter(filePath), CsvPreference.STANDARD_PREFERENCE)){
            String[] header={"ProductId", "name", "price", "inventory"};
            beanWriter.writeHeader(header);

            for(Product  product :products){
                beanWriter.write(product, header);
            }
            System.out.println("successfully wrote");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
