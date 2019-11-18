package com.vanke.cn;

import com.vanke.utils.Test;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.IOException;


@SpringBootApplication
public class AutoApplication {
    public static void main(String[] args) throws IOException, WriteException, BiffException {
        SpringApplication.run(AutoApplication.class);
        Test.test1();
    }
}
