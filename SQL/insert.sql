INSERT INTO `user` (`id`, `full_name`, `email`, `address`, `dob`, `mobile`, `password`, `confirm_password`) VALUES
(29, 'krutika subhash fating', 'pranay@gmail.com', 'karla road,sahayog colony, pipri meghe wardha', '2021-01-05', '7083924873', '123', '123'),
(30, 'PRANAY FATINHG', 'pranay2@gmail.com', 'karla road,sahayog colony, pipri meghe wardha', '2020-12-28', '7083924873', '123', '123');

INSERT INTO `product` (`id`, `seller_id`, `product_name`, `details`, `minimum_bid`, `opening_date`, `closing_date`, `email`, `mobile`, `status`) VALUES
(37, 29, 'laptpp', 'good condition', 342, '2021-01-12', '2021-01-29', 'drprashantsawarkar@rediffmail.com', '9764023911', 'Active');

INSERT INTO `auction` (`id`, `seller_id`, `buyer_id`, `product_id`, `date`, `bid_amount`, `status`) VALUES
(19, 29, 30, 37, '2021-01-27', 3244, 'Accepted');