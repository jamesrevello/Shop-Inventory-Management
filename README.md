In this project, I built a Spring-based frontend Shop Inventory Management Application on top of an existing Java backend. Below you can see a general summary of the commits I performed (pulled from my Gitlab). 

--------------------------------------
#### C.  Customized the HTML user interface to include the shop name, product names, and parts names.
| STEP | FILE            | LINES | CHANGES            |
|:-----|:----------------|:------|:-------------------|
| C    | mainscreen.html | 14    | Business title     |
|      |                 | 21,53 | Customized headers |

#### D.  Added an “About” page to the application with quick site description. Included navigation to and from the “About” page and the main screen.
| STEP | FILE            | LINES | CHANGES                                        |
|:-----|:----------------|:------|:-----------------------------------------------|
| D    | about.html      | 1-15  | Created html page                              |
|      |                 | 5     | Custom title                                   |
|      |                 | 9     | Custom heading                                 |
|      |                 | 10-11 | Added company info                             |
|      |                 | 12    | Added call-to-action                           |
|      | AboutController | 1-12  | Created autowired controller for about.html    |
|      |                 | 14    | Created request mapping to serve up about page |
|      | about.html      | 16    | Created link back to mainscreen                |

#### E.  Added a sample inventory with five parts and five products. Made sure not to overwrite existing data in the database.
| STEP | FILE          | LINES  | CHANGES                                         |
|:-----|:--------------|:-------|:------------------------------------------------|
| E    | BootStrapData | 38, 88 | Created condition check for empty repositories  |
|      |               | 39-77  | If parts = empty, generate 5 sample parts       |
|      |               | 89-102 | If products = empty, generate 5 sample products |

#### F.  Added a “Buy Now” button to your product list. 
| STEP | FILE                 | LINES | CHANGES                                             |
|:-----|:---------------------|:------|:----------------------------------------------------|
| F    | mainscreen.html      | 89    | Created buy now button with purchase confirmation   |
|      |                      | 88    | Buy button is placed next to update/delete          |
|      | purchaseConfirm.html | 1-15  | Created purchase confirmation page                  |
|      | purchaseFailed.html  | 1-15  | Created purchase failed page                        |
|      | PurchaseController   | 1-38  | Created controller for purchases                    |
|      |                      | 14    | Imported Optional util to resolve nullptr issue     |
|      |                      | 24    | Requested param for specific button click           |
|      |                      | 27-33 | If branch to check if item is in stock              |
|      |                      | 32    | If true, decrement by one and route to confirmation |
|      |                      | 34    | Else, route to purchase failed page                 |

#### G. Modified the parts to track maximum and minimum inventory
| STEP | FILE                        | LINES   | CHANGES                                          |
|:-----|:----------------------------|:--------|:-------------------------------------------------|
| G    | Part.java                   | 33-35   | Created min and max inventory fields             |
|      |                             | 58-66   | Generated part constructor including max/min     |
|      |                             | 104-110 | Generated getters/setters for new fields         |
|      | BootStrapData.java          | 45-86   | Added min/max inventory setters for sample parts |
|      | InhousePartForm.html        | 24-28   | Added min/max text fields                        |
|      | OutsourcedPartForm.html     | 25-29   | Added min/max text fields                        |
|      | application.properties      | 6       | Renamed database file                            |
|      | Part.java                   | 68-74   | Created function to check if inventory is valid  |
|      | AddInhousePartController    | 42-47   | Created binding result if inventory invalid      |
|      | AddOutsourcedPartController | 43-47   | Created binding result if inventory invalid      |

#### H. Added validation for between or at the maximum and minimum fields. 
| STEP | FILE                        | LINES | CHANGES                                                        |
|:-----|:----------------------------|:------|:---------------------------------------------------------------|
| H    | EnufpartsValidator          | 37-42 | Added branch to check if making product will set parts < min   |
|      | ValidEnufParts              | 20    | Specified error message for if inv < min                       |
|      | AddInhousePartController    | 45-50 | Added specific errors for inventory above min/max              |
|      | AddOutsourcedPartcontroller | 47-52 | Added specific errors for inventory above min/max              |

#### I.  Added two unit tests for the maximum and minimum fields to the PartTest class in the test package.
| STEP | FILE          | LINES   | CHANGES                                                                 |
|:-----|:--------------|:--------|:------------------------------------------------------------------------|
| I    | PartTest.java | 104-120 | Created unit tests for getMinInv and getMaxInv (0 and 99, respectively) |

#### J.  Removeed the class files for any unused validators in order to clean up the code
| STEP | FILE                | LINES     | CHANGES                                         |
|:-----|:--------------------|:----------|:------------------------------------------------|
| J    | DeletePartValidator | All Lines | Removed DeletePartValidator, as it was not used |
