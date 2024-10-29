package com.example.demo.bootstrap;

import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Product;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        long oPartRepositoryCount = outsourcedPartRepository.count();
        long productRepositoryCount = productRepository.count();

        if (oPartRepositoryCount == 0) {
            OutsourcedPart samplePart1 = new OutsourcedPart();
            samplePart1.setCompanyName("INTEL");
            samplePart1.setName("i5 Processor");
            samplePart1.setInv(5);
            samplePart1.setPrice(20.0);
            samplePart1.setId(100L);
            samplePart1.setMaxInv(10);
            samplePart1.setMinInv(1);
            outsourcedPartRepository.save(samplePart1);

            OutsourcedPart samplePart2 = new OutsourcedPart();
            samplePart2.setCompanyName("INTEL");
            samplePart2.setName("i7 Processor");
            samplePart2.setInv(5);
            samplePart2.setPrice(30.0);
            samplePart2.setId(100L);
            samplePart2.setMaxInv(10);
            samplePart2.setMinInv(1);
            outsourcedPartRepository.save(samplePart2);

            OutsourcedPart samplePart3 = new OutsourcedPart();
            samplePart3.setCompanyName("INTEL");
            samplePart3.setName("i9 Processor");
            samplePart3.setInv(5);
            samplePart3.setPrice(40.0);
            samplePart3.setId(100L);
            samplePart3.setMaxInv(10);
            samplePart3.setMinInv(1);
            outsourcedPartRepository.save(samplePart3);

            OutsourcedPart samplePart4 = new OutsourcedPart();
            samplePart4.setCompanyName("NVIDIA");
            samplePart4.setName("RTX 4070 GPU");
            samplePart4.setInv(5);
            samplePart4.setPrice(50.0);
            samplePart4.setId(100L);
            samplePart4.setMaxInv(10);
            samplePart4.setMinInv(1);
            outsourcedPartRepository.save(samplePart4);

            OutsourcedPart samplePart5 = new OutsourcedPart();
            samplePart5.setCompanyName("NVIDIA");
            samplePart5.setName("RTX 4080 GPU");
            samplePart5.setInv(5);
            samplePart5.setPrice(60.0);
            samplePart5.setId(100L);
            samplePart5.setMaxInv(10);
            samplePart5.setMinInv(1);
            outsourcedPartRepository.save(samplePart5);

        }

        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            System.out.println(part.getName()+" "+part.getCompanyName());
        }



        if(productRepositoryCount == 0) {
            Product gamer9000= new Product("Gamer 9000",1999.0,3);
            productRepository.save(gamer9000);

            Product productivityPlus= new Product("Productivity Plus",999.0,3);
            productRepository.save(productivityPlus);

            Product gamer500= new Product("Gamer 500 (Gen1)",777.0,3);
            productRepository.save(gamer500);

            Product cheapo5= new Product("Cheapo 5",15.0,3);
            productRepository.save(cheapo5);

            Product flackbookPear= new Product("Flackbook Pear Pro",200000.0,3);
            productRepository.save(flackbookPear);
        }



        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts"+partRepository.count());
        System.out.println(partRepository.findAll());

    }
}
