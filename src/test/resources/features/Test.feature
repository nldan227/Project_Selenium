@Automation-Exercise
Feature: demo

  @TestCase-1
    Scenario Outline: Register User
      Given Navigate to Automation Exercise
      When Click on Signup/Login button
      Then "New User Signup!" heading is visible
      When Enter name "<name>" and email "<email>" in the signup form.
      And Click Signup button
      Then "Enter Account Information" heading is visible
      When Fill account details with title "<title>", name "<name>", password "<password>" and date of birth "<dob>"
      And Select checkbox "Sign up for our newsletter!"
      And Select checkbox "Receive special offers from our partners!"
      And Fill address details with First name "<firstName>", Last name "<lastName>", Company "<company>", Address "<address1>", Address2 "<address2>", Country "<country>", State "<state>", City "<city>", Zipcode "<zipcode>", Mobile Number "<mobile>"
      And Click Create Account button
      Then "Account Created!" heading is visible
      When Click Continue button
      Then "Logged in as <name>" label is visible
      When Click Delete Account button
      Then "Account Deleted!" heading is visible

    Examples:
      | title | name | email                | password | dob            | firstName | lastName | company | address1        | address2        | country | state   | city    | zipcode | mobile     |
      | Mrs   | Dan  | dan1211@yopmail.com  | 123456   | 1-January-2000 | Linh Dan  | Nguyen   | AGH     | 141 Chien Thang | 142 Chien Thang | Canada  | Ontario | Toronto | M5H2N2 | 1234567890  |

    @TestCase-2
    Scenario: Login User with correct email and password
      Given Navigate to Automation Exercise
      When Click on Signup/Login button
      Then "Login to your account" heading is visible
      When Login with email "dan2612026@yopmail.com" and password "123456"
      Then "Logged in as Danne" label is visible

    @TestCase-3
      Scenario: Login User with incorrect
        Given Navigate to Automation Exercise
        When Click on Signup/Login button
        Then "Login to your account" heading is visible
        When Login with email "dan2612026@yopmail.com" and password "123456khongtontai"
        Then Message "Your email or password is incorrect!" is visible

    @TestCase-4
      Scenario: Logout User
        Given Navigate to Automation Exercise
        When Click on Signup/Login button
        Then "Login to your account" heading is visible
        When Login with email "dan2612026@yopmail.com" and password "123456"
        Then "Logged in as Danne" label is visible
        When Click Logout button
        Then "Login to your account" heading is visible

    @TestCase-5 @CreateAcc
      Scenario:  Register User with existing email
        When Click on Signup/Login button
        Then "New User Signup!" heading is visible
        When Enter name "Dann" and email existEmail
        And Click Signup button
        Then Message "Email Address already exist!" is visible

    @TestCase-6
      Scenario: Contact Us Form
        Given Navigate to Automation Exercise
        When Click on Contact Us button
        Then "Get In Touch" heading is visible
        When Enter name "Dann", email "dann123@yopmail.com", subject "ABC", messsage "ABC123" and upload file in the Contact form
        And Click Submit button
        And Click OK button
        Then Message "Success! Your details have been submitted successfully." is visible
        When Click Home button
        Then Home page is visible

  @TestCase-7
    Scenario: Verify Test Cases Page
      Given Navigate to Automation Exercise
      When Click Test Cases button
      Then "Test Cases" heading is visible

  @TestCase-8
    Scenario: Verify All Products and product detail page
      Given Navigate to Automation Exercise
      When Click on Products button
      Then "All Products" heading is visible
      And The products list is visible
      When Click on View Product of product 1
      Then User is landed to product detail page
      And Detail info is visible: product name, category, price, availability, condition, brand

  @TestCase-9
    Scenario: Search Product
      Given Navigate to Automation Exercise
      When Click on Products button
      Then "All Products" heading is visible
      When Enter product name "Top" in search input and click search button
      Then "Searched Products" heading is visible
      And The products list is visible
      And All products name contain searched keyword

  @TestCase-10
    Scenario: Verify Subscription in home page
      Given Navigate to Automation Exercise
      When Scroll down to footer
      Then "Subscription" heading is visible
      When Enter email address in input and click arrow button
      Then Message "You have been successfully subscribed!" is visible

  @TestCase-11
    Scenario: Verify Subscription in Cart page
      Given Navigate to Automation Exercise
      When Click Cart button
      And Scroll down to footer
      Then "Subscription" heading is visible
      When Enter email address in input and click arrow button
      Then Message "You have been successfully subscribed!" is visible

  @TestCase-12
    Scenario: Add Products in Cart
      Given Navigate to Automation Exercise
      When Click on Products button
      And Hover over product 1 and click Add to cart
      And Click Continue Shopping button
      And Hover over product 2 and click Add to cart
      And Click View Cart button
      Then Products are added to Cart
      And their prices, quantity and total price is displayd correctly

  @TestCase-13
    Scenario:  Verify Product quantity in Cart
      Given Navigate to Automation Exercise
      When Click on View Product of product 2
      Then User is landed to product detail page
      When Increase quantity to 4
      And Click Add to cart button on detail product page
      And Click View Cart button
      Then Product is displayed in cart page with exact quantity

  @TestCase-14
    Scenario: Place Order: Register while Checkout
      Given Navigate to Automation Exercise
      When Hover over product 3 and click Add to cart
      And Click Continue Shopping button
      And Click Cart button
      Then Cart page is displayed
      When Click Proceed To Checkout button
      And Click Register/Login button
      And Fill all details in Signup and create acc
      Then "Account Created!" heading is visible
      And Click Continue button
      Then 'Logged in as username' is displayed at top
      When Click Cart button
      And Click Proceed To Checkout button
      Then Address Details display correctly
      And Review Your Order display correctly
      When Enter description "description 123" in comment text area
      And Click Place Order button
      And Enter payment details: Name on Card, Card Number, CVC, Expiration date
      And Click Pay and Confirm Order button
      Then Message "Congratulations! Your order has been confirmed!" is visible
      When Click Delete Account button
      Then "Account Deleted!" heading is visible

  @TestCase-15
    Scenario: Place Order: Register before Checkout
      Given Navigate to Automation Exercise
      When Click on Signup/Login button
      And Fill all details in Signup and create acc
      Then "Account Created!" heading is visible
      And Click Continue button
      Then 'Logged in as username' is displayed at top
      When Hover over product 3 and click Add to cart
      And Click Continue Shopping button
      And Click Cart button
      Then Cart page is displayed
      When Click Proceed To Checkout button
      Then Address Details display correctly
      And Review Your Order display correctly
      When Enter description "description 123" in comment text area
      And Click Place Order button
      And Enter payment details: Name on Card, Card Number, CVC, Expiration date
      And Click Pay and Confirm Order button
      Then Message "Congratulations! Your order has been confirmed!" is visible
      When Click Delete Account button
      Then "Account Deleted!" heading is visible

  @TestCase-16 @CreateAcc
    Scenario: Place Order: Login before Checkout
      Given Navigate to Automation Exercise
      When Click on Signup/Login button
      And Login with created account
      Then 'Logged in as username' is displayed at top
      When Hover over product "Blue Top" and click Add to cart
      And Click Continue Shopping button
      And Click Cart button
      Then Cart page is displayed
      When Click Proceed To Checkout button
      Then Address Details display correctly
      And Review Your Order display correctly
      When Enter description "description 123" in comment text area
      And Click Place Order button
      And Enter payment details: Name on Card, Card Number, CVC, Expiration date
      And Click Pay and Confirm Order button
      Then Message "Congratulations! Your order has been confirmed!" is visible
      When Click Delete Account button
      Then "Account Deleted!" heading is visible

    @TestCase-17
      Scenario: Remove Products From Cart
        Given Navigate to Automation Exercise
        When Hover over product "Blue Top" and click Add to cart
        And Click Continue Shopping button
        And Click Cart button
        Then Cart page is displayed
        When Click X button corresponding to "Blue Top" product
        Then That product is removed from the cart

    @TestCase-18
      Scenario: View Category Products
        Given Navigate to Automation Exercise
        Then "Category" heading is visible
        When Click on "Women" category
        And Click on "Tops" sub category under "Women"
        Then "Women - Tops Products" heading is visible
        When Click on "Men" category
        And Click on "Jeans" sub category under "Men"
        Then "Men - Jeans Products" heading is visible

    @TestCase-19
      Scenario: View & Cart Brand Products
        Given Navigate to Automation Exercise
        When Click on Products button
        Then "Brands" heading is visible
        When Click on "Polo" brand
        Then "Brand - Polo Products" heading is visible
        And The products list is visible
        When Click on "Madame" brand
        Then "Brand - Madame Products" heading is visible
        And The products list is visible

    @TestCase-20
      Scenario: Search Products and Verify Cart After Login
        Given Navigate to Automation Exercise
        When Click on Products button
        Then "All Products" heading is visible
        When Enter product name "Top" in search input and click search button
        Then "Searched Products" heading is visible
        And The products list is visible
        And All products name contain searched keyword
        When Hover over product "Blue Top" and click Add to cart
        And Click Continue Shopping button
        And Hover over product "Winter Top" and click Add to cart
        And Click View Cart button
        Then Products are added to Cart
        When Click on Signup/Login button
        And Login with email "dan2612026@yopmail.com" and password "123456"
        And Click Cart button
        Then Products are added to Cart

    @TestCase-21
      Scenario: Add review on product
        Given Navigate to Automation Exercise
        When Click on Products button
        Then "All Products" heading is visible
        When Click on View Product of product 1
        Then Message "Write Your Review" is visible
        And Fill review form: Enter name, email and review
        And Click Submit review button
        Then Message "Thank you for your review." is visible

    @TestCase-22
      Scenario: Add to cart from Recommended items
        Given Navigate to Automation Exercise
        When Scroll down to footer
        Then Recommend items are visible
        When Click on Add To Cart of product "Blue Top" on Recommended product
        And Click View Cart button
        Then Products are added to Cart

    @TestCase-23
      Scenario: Verify address details in checkout page
        Given Navigate to Automation Exercise
        When Click on Signup/Login button
        And Fill all details in Signup and create acc
        Then "Account Created!" heading is visible
        When Click Continue button
        Then 'Logged in as username' is displayed at top
        When Hover over product "Winter Top" and click Add to cart
        And Click View Cart button
        Then Cart page is displayed
        When Click Proceed To Checkout button
        Then Delivery address and billing address is same address filled at the time registration of account
        When Click Delete Account button
        Then "Account Deleted!" heading is visible

    @TestCase-24 @deleteInvoice
      Scenario: Download Invoice after purchase order
        Given Navigate to Automation Exercise
        When Hover over product 3 and click Add to cart
        And Click View Cart button
        Then Cart page is displayed
        When Click Proceed To Checkout button
        And Click Register/Login button
        And Fill all details in Signup and create acc
        Then "Account Created!" heading is visible
        And Click Continue button
        Then 'Logged in as username' is displayed at top
        When Click Cart button
        And Click Proceed To Checkout button
        Then Address Details display correctly
        And Review Your Order display correctly
        When Enter description "description 123456" in comment text area
        And Click Place Order button
        And Enter payment details: Name on Card, Card Number, CVC, Expiration date
        And Click Pay and Confirm Order button
        Then Message "Congratulations! Your order has been confirmed!" is visible
        When Click Download Invoice button
        Then Invoice is downloaded successfully
        When Click Continue button
        When Click Delete Account button
        Then "Account Deleted!" heading is visible

  @TestCase-25
      Scenario: Verify Scroll Up using 'Arrow' button and Scroll Down functionality
        Given Navigate to Automation Exercise
        When Scroll down to footer
        Then "Subscription" heading is visible
        When Click on arrow at bottom right side to move upward
        Then "Full-Fledged practice website for Automation Engineers" heading is visible

    @TestCase-26
      Scenario: Verify Scroll Up without 'Arrow' button and Scroll Down functionality
        Given Navigate to Automation Exercise
        When Scroll down to footer
        Then "Subscription" heading is visible
        When Scroll up page to top
        Then "Full-Fledged practice website for Automation Engineers" heading is visible