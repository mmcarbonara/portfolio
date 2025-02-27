--categoriesテーブル
INSERT IGNORE INTO categories (id, name) VALUES (1, '和食');
INSERT IGNORE INTO categories (id, name) VALUES (2, '韓国料理');
INSERT IGNORE INTO categories (id, name) VALUES (3, '中華料理');
INSERT IGNORE INTO categories (id, name) VALUES (4, 'イタリア料理');
INSERT IGNORE INTO categories (id, name) VALUES (5, 'エスニック料理');
INSERT IGNORE INTO categories (id, name) VALUES (6, '洋食');
INSERT IGNORE INTO categories (id, name) VALUES (7, 'その他');

-- restaurantsテーブル
INSERT IGNORE INTO restaurants (id, name, image_name, description, phone_number, postal_code, capacity, address, holiday, opening_time, closing_time, price, categories_id) VALUES (1, '潮風海丼', 'photo1.jpg', '新鮮な海の幸を贅沢に使った海鮮丼。名古屋港直送の魚介を、特製の出汁タレとともに楽しめます。名古屋港近くの漁港風の店。落ち着いた雰囲気で、昼は漁師たちも訪れる人気の海鮮丼店。旬の海鮮を使ったメニューも豊富。', '090-1111-1111', '111-1111', 25, '愛知県名古屋市中区栄X-XX-XX', '木','11:00:00','21:00:00', 1000, 1);
INSERT IGNORE INTO restaurants (id, name, image_name, description, phone_number, postal_code, capacity, address, holiday, opening_time, closing_time, price, categories_id) VALUES (2, '名港しらす焼き', 'photo2.jpg', '新鮮な釜揚げしらすを、特製ダレとともに提供するしらす専門店。名古屋名港エリアのカジュアルな焼き魚店。地元漁師から仕入れた新鮮なしらすを、釜揚げにして提供。昼時は地元客で賑わう人気店。','090-1112-1112', '111-1112', 20, '愛知県名古屋市中区栄X-XX-XX', '金','11:00:00','22:00:00', 1100, 1);
INSERT IGNORE INTO restaurants (id, name, image_name, description, phone_number, postal_code, capacity, address, holiday, opening_time, closing_time, price, categories_id) VALUES (3, 'おばんざい定食「まる家」', 'photo3.jpg', '季節の野菜や魚を使ったおばんざいを中心に、バランスの良い定食を提供するお店。', '090-1111-1113', '111-1113', 18, '愛知県名古屋市中区栄X-XX-XX', '木','11:00:00','20:00:00', 1300, 1);
INSERT IGNORE INTO restaurants (id, name, image_name, description, phone_number, postal_code, capacity, address, holiday, opening_time, closing_time, price, categories_id) VALUES (4, '鰻定食「名古屋うな吉」', 'photo4.jpg', '名古屋の名物、ひつまぶしや鰻の蒲焼き定食を提供する専門店。', '090-1111-1114', '111-1114', 10, '愛知県名古屋市中区栄X-XX-XX', '木', '11:00:00', '23:00:00', 1800, 1);
INSERT IGNORE INTO restaurants (id, name, image_name, description, phone_number, postal_code, capacity, address, holiday, opening_time, closing_time, price, categories_id) VALUES (5, '味噌鍋 たまり屋', 'photo5.jpg', 'さまざまな具材を、名古屋特有の赤味噌を使ったスープで煮込んだ料理。味噌の深いコクと温かみのある具材が絶妙に調和している。', '090-1111-1115', '111-1115', 30, '愛知県名古屋市中区栄X-XX-XX', '水', '11:00:00', '24:00:00', 2000, 1);
INSERT IGNORE INTO restaurants (id, name, image_name, description, phone_number, postal_code, capacity, address, holiday, opening_time, closing_time, price, categories_id) VALUES (6, '山本屋', 'photo6.jpg', '地元で収穫した野菜を使用する名古屋の老舗店', '090-1111-1116', '111-1116', 21, '愛知県名古屋市中区栄X-XX-XX', '木', '11:00:00', '23:00:00', 2200, 1);
INSERT IGNORE INTO restaurants (id, name, image_name, description, phone_number, postal_code, capacity, address, holiday, opening_time, closing_time, price, categories_id) VALUES (7, '酒肴 鳥しん', 'photo7.jpg', '鶏肉料理が豊富な居酒屋で、焼き鳥や鳥刺しを中心に様々な鶏料理を楽しめる', '090-1111-1117', '111-1117', 30, '愛知県名古屋市中区栄X-XX-XX', '木', '11:00:00', '24:00:00', 1000, 1);
INSERT IGNORE INTO restaurants (id, name, image_name, description, phone_number, postal_code, capacity, address, holiday, opening_time, closing_time, price, categories_id) VALUES (8, '大衆酒場 いろは', 'photo8.jpg', '地元で愛されているカジュアルな居酒屋。焼き魚や串揚げ、煮込み料理など、手頃な価格で美味しい料理が楽しめる', '090-1111-1118', '111-1118', 35, '愛知県名古屋市中区栄X-XX-XX', '月', '16:00:00', '23:00:00', 1000, 1);
INSERT IGNORE INTO restaurants (id, name, image_name, description, phone_number, postal_code, capacity, address, holiday, opening_time, closing_time, price, categories_id) VALUES (9, '名古屋蕎麦処 八重田屋', 'photo9.jpg', 'こだわりの蕎麦を提供する店。特に手打ち蕎麦が人気で、風味豊かなつゆと共に味える。落ち着いた和の空間で、ランチにもディナーにもぴったり', '090-1111-1119', '111-1119', 20, '愛知県名古屋市中区栄X-XX-XX', '火', '17:00:00', '23:00:00', 1800, 1);
INSERT IGNORE INTO restaurants (id, name, image_name, description, phone_number, postal_code, capacity, address, holiday, opening_time, closing_time, price, categories_id) VALUES (10, 'うどん処 ひやひや', 'photo10.jpg', '名古屋ならではの名古屋風うどんを提供する店。コシの強い麺と味噌ベースのスープが特徴で、ボリューム満点なうどんが楽しめる', '090-1111-2000', '111-1120', 25, '愛知県名古屋市中区栄X-XX-XX', '木', '11:00:00', '20:00:00', 1100, 1);
INSERT IGNORE INTO restaurants (id, name, image_name, description, phone_number, postal_code, capacity, address, holiday, opening_time, closing_time, price, categories_id) VALUES (11, 'カレー屋 ゴーゴーカレー', 'photo11.jpg', 'ゴーゴーカレーは、名古屋で人気のカレー専門店。濃厚でスパイシーなルーが特徴で、たっぷりのトッピングが魅力。手軽に食べられるけど、満足感も大きい。地元でも愛されてるお店。', '090-1111-1121', '111-1121', 15, '愛知県名古屋市中区栄X-XX-XX', '木', '11:00:00', '21:00:00', 1200, 5);
INSERT IGNORE INTO restaurants (id, name, image_name, description, phone_number, postal_code, capacity, address, holiday, opening_time, closing_time, price, categories_id) VALUES (12, 'カレーショップムー', 'photo12.jpg', 'ムーは、こだわりのスパイスを使ったカレーが評判の店。野菜やお肉の旨みがしっかり感じられる、深みのある味わい。シンプルで落ち着いた店内で、ゆっくりカレーを楽しめる。', '090-1111-1122', '111-1122', 20, '愛知県名古屋市中区栄X-XX-XX', '木', '11:00:00', '20:00:00', 1800, 5);
INSERT IGNORE INTO restaurants (id, name, image_name, description, phone_number, postal_code, capacity, address, holiday, opening_time, closing_time, price, categories_id) VALUES (13, 'バーガーショップ フィズ', 'photo13.jpg', 'フィズは、ジューシーなパティと特製ソースが特徴のハンバーガーショップ。フレッシュな野菜とともに、ボリューム満点なバーガーを楽しめる。カジュアルな雰囲気で、友達と気軽に行けるお店。', '090-1111-1123', '111-1123', 25, '愛知県名古屋市中区栄X-XX-XX', '木', '11:00:00', '20:00:00', 1100, 6);
INSERT IGNORE INTO restaurants (id, name, image_name, description, phone_number, postal_code, capacity, address, holiday, opening_time, closing_time, price, categories_id) VALUES (14, 'グルメバーガー ダイナー', 'photo14.jpg', 'ダイナーは、アメリカンスタイルのハンバーガーを提供する店。厳選された食材を使い、シンプルだけど味わい深いハンバーガーを味わえる。店内はおしゃれで、食事を楽しみながらリラックスできる空間。', '090-1111-1124', '111-1124', 18, '愛知県名古屋市中区栄X-XX-XX', '木', '11:00:00', '19:00:00', 1200, 6);
INSERT IGNORE INTO restaurants (id, name, image_name, description, phone_number, postal_code, capacity, address, holiday, opening_time, closing_time, price, categories_id) VALUES (15, 'ピザ屋 マルゲリータ', 'photo15.jpg', 'マルゲリータは、シンプルで本格的なナポリピザが楽しめるお店。薄い生地にトマトソース、モッツァレラチーズが絶妙に絡み、何度でも食べたくなる味。落ち着いた雰囲気で、デートや友達との食事にぴったり。', '090-1111-1125', '111-1125', 25, '愛知県名古屋市中区栄X-XX-XX', '月', '11:00:00', '22:00:00', 1800, 4);
INSERT IGNORE INTO restaurants (id, name, image_name, description, phone_number, postal_code, capacity, address, holiday, opening_time, closing_time, price, categories_id) VALUES (16, 'ピザダイニング ロッソ', 'photo16.jpg', 'ロッソは、こだわりの具材を使ったピザが特徴。新鮮な野菜やお肉をたっぷり使い、アツアツのピザが楽しめる。カジュアルな雰囲気の店内で、気軽に美味しいピザを味わえる。', '090-1111-1126', '111-1126', 35, '愛知県名古屋市中区栄X-XX-XX', '火', '11:00:00', '20:00:00', 1200, 4);
INSERT IGNORE INTO restaurants (id, name, image_name, description, phone_number, postal_code, capacity, address, holiday, opening_time, closing_time, price, categories_id) VALUES (17, 'パスタ屋 トラットリア・カルディナーレ', 'photo17.jpg', 'トラットリア・カルディナーレは、本格的なイタリアンパスタが楽しめる店。モチモチの生パスタに、旬の食材を使ったソースが絡み、絶品の味わい。カジュアルな雰囲気で、友達や家族と気軽に楽しめる。', '090-1111-1127', '111-1127', 20, '愛知県名古屋市中区栄X-XX-XX', '日', '11:00:00', '20:00:00', 1100, 4);
INSERT IGNORE INTO restaurants (id, name, image_name, description, phone_number, postal_code, capacity, address, holiday, opening_time, closing_time, price, categories_id) VALUES (18, 'パスタダイニング アルベロ', 'photo18.jpg', 'アルベロは、シンプルでありながら深い味わいのパスタが特徴。トマトソースやクリームソース、どれも手作りで、素材の良さが際立つ。落ち着いた雰囲気の店内で、ゆっくりと食事が楽しめる。', '090-1111-1128', '111-1128', 15, '愛知県名古屋市中区栄X-XX-XX', '月', '11:00:00', '20:00:00', 1000, 4);
INSERT IGNORE INTO restaurants (id, name, image_name, description, phone_number, postal_code, capacity, address, holiday, opening_time, closing_time, price, categories_id) VALUES (19, 'お好み焼き ひろや', 'photo19.jpg', 'ひろやは、ふわふわの生地と豊富なトッピングが特徴のお好み焼き屋。鉄板で提供されるので、アツアツのまま楽しめる。シンプルなものから変わり種まで、どれも美味しくて、地元の人にも愛されている。', '090-1111-1129', '111-1129', 30, '愛知県名古屋市中区栄X-XX-XX', '木', '11:00:00', '24:00:00',1500, 1);
INSERT IGNORE INTO restaurants (id, name, image_name, description, phone_number, postal_code, capacity, address, holiday, opening_time, closing_time, price, categories_id) VALUES (20, 'お好み焼き まるよし', 'photo20.jpg', 'まるよしは、ボリューム満点のお好み焼きが楽しめる店。特製のソースと豊富な具材が絶妙にマッチし、一口食べればやみつきになる。カジュアルな雰囲気で、気軽に立ち寄れるお店。', '090-1111-1130', '111-1130', 30, '愛知県名古屋市中区栄X-XX-XX', '木', '11:00:00', '24:00:00', 1800, 1);
INSERT IGNORE INTO restaurants (id, name, image_name, description, phone_number, postal_code, capacity, address, holiday, opening_time, closing_time, price, categories_id) VALUES (21, '韓国料理 ソウル亭', 'photo21.jpg', 'ソウル亭は、本場の韓国料理が楽しめるお店。辛さがクセになるビビンバや、ジューシーな焼き肉が人気。落ち着いた雰囲気で、友達や家族と一緒に本格的な韓国料理を味わえる。', '090-1111-1131', '111-1131', 25, '愛知県名古屋市中区栄X-XX-XX', '月', '16:00:00', '23:00:00', 1400, 2);
INSERT IGNORE INTO restaurants (id, name, image_name, description, phone_number, postal_code, capacity, address, holiday, opening_time, closing_time, price, categories_id) VALUES (22, '韓国屋台 チメル', 'photo22.jpg', 'チメルは、韓国の屋台風の料理が楽しめる店。プルコギやチヂミ、韓国風ラーメンなどが豊富で、どれもボリューム満点。アットホームな雰囲気で、気軽に本場の味を楽しめる。', '090-1111-1132', '111-1132', 16, '愛知県名古屋市中区栄X-XX-XX', '木', '15:00:00', '23:00:00', 1500, 2);
INSERT IGNORE INTO restaurants (id, name, image_name, description, phone_number, postal_code, capacity, address, holiday, opening_time, closing_time, price, categories_id) VALUES (23, '餃子屋 龍王', 'photo23.jpg', '龍王は、ジューシーで香ばしい焼き餃子が特徴のお店。皮はパリッと、中は肉汁たっぷりで、ビールとの相性も抜群。カジュアルな雰囲気で、サクッと一杯と一緒に楽しむのにぴったりな場所。', '090-1111-1133', '111-1133', 30, '愛知県名古屋市中区栄X-XX-XX', '木', '11:00:00', '23:00:00', 1800, 3);
INSERT IGNORE INTO restaurants (id, name, image_name, description, phone_number, postal_code, capacity, address, holiday, opening_time, closing_time, price, categories_id) VALUES (24, '餃子専門店 福餃子', 'photo24.jpg', '福餃子は、手作りの餡と新鮮な具材を使った餃子が味わえる店。焼き餃子はもちろん、水餃子や揚げ餃子も楽しめる。シンプルな店内で、気軽に美味しい餃子を堪能できる。', '090-1111-1134', '111-1134', 10, '愛知県名古屋市中区栄X-XX-XX', '水', '11:00:00', '23:00:00', 1500, 3);
INSERT IGNORE INTO restaurants (id, name, image_name, description, phone_number, postal_code, capacity, address, holiday, opening_time, closing_time, price, categories_id) VALUES (25, 'チャーハン専門店 龍華', 'photo25.jpg', '龍華は、香ばしくてパラパラなチャーハンが自慢のお店。シンプルながらも具材の旨味がしっかりと感じられ、一度食べたらやみつきになる味。ランチにもぴったりな、手軽に食べられる場所。', '090-1111-1135', '111-1135', 20, '愛知県名古屋市中区栄X-XX-XX', '月', '11:00:00', '25:00:00', 1100, 3);
INSERT IGNORE INTO restaurants (id, name, image_name, description, phone_number, postal_code, capacity, address, holiday, opening_time, closing_time, price, categories_id) VALUES (26, '中華料理 まるみ', 'photo26.jpg', 'まるみは、バリエーション豊かなチャーハンを楽しめる店。エビやチャーシュー、野菜などがたっぷり入ったチャーハンが特徴で、ボリューム満点。こだわりの炒め具合で、家庭的な味わいが楽しめる。', '090-1111-1136', '111-1136', 25, '愛知県名古屋市中区栄X-XX-XX', '木', '16:00:00', '23:00:00', 1000, 3);
INSERT IGNORE INTO restaurants (id, name, image_name, description, phone_number, postal_code, capacity, address, holiday, opening_time, closing_time, price, categories_id) VALUES (27, 'ラーメン 笑福', 'photo27.jpg', '笑福は、あっさりとしたスープと自家製のもちもち麺が特徴のラーメン店。豚骨や鶏ガラをベースにしたスープが絶妙で、どんなトッピングとも相性抜群。地元の人に愛される定番のラーメン店。', '090-1111-1137', '111-1137', 15, '愛知県名古屋市中区栄X-XX-XX', '日', '11:00:00', '25:00:00', 1200, 1);
INSERT IGNORE INTO restaurants (id, name, image_name, description, phone_number, postal_code, capacity, address, holiday, opening_time, closing_time, price, categories_id) VALUES (28, 'ラーメン 龍神', 'photo28.jpg', '龍神は、濃厚なスープと細麺が特徴のラーメン店。特に、特製の豚骨醤油ラーメンが人気で、しっかりとした味わいがクセになる。カウンター席が中心で、ラーメンをすぐに楽しめる場所。', '090-1111-1138', '111-1138', 20, '愛知県名古屋市中区栄X-XX-XX', '木', '11:00:00', '26:00:00', 1100, 1);
INSERT IGNORE INTO restaurants (id, name, image_name, description, phone_number, postal_code, capacity, address, holiday, opening_time, closing_time, price, categories_id) VALUES (29, '寿司処 鮨松', 'photo29.jpg', '鮨松は、新鮮なネタと職人の技が光る寿司店。ネタの種類も豊富で、季節ごとのおすすめが楽しめる。落ち着いた雰囲気の店内で、ゆっくり本格的な寿司を堪能できる。', '090-1111-1139', '111-1139', 10, '愛知県名古屋市中区栄X-XX-XX', '日', '11:00:00', '18:00:00', 1500, 1);
INSERT IGNORE INTO restaurants (id, name, image_name, description, phone_number, postal_code, capacity, address, holiday, opening_time, closing_time, price, categories_id) VALUES (30, '回転寿司 魚福', 'photo30.jpg', '魚福は、新鮮な魚を使った回転寿司が楽しめるお店。種類豊富なネタが回転しており、気軽に選んで楽しめる。コスパも良く、家族連れにも人気の場所。', '090-1111-1140', '111-1140', 30, '愛知県名古屋市中区栄X-XX-XX', '月', '11:00:00', '23:00:00', 1200, 1);
INSERT IGNORE INTO restaurants (id, name, image_name, description, phone_number, postal_code, capacity, address, holiday, opening_time, closing_time, price, categories_id) VALUES (31, 'タイ料理 サワディー', 'photo31.jpg', 'サワディーは、本格的なタイ料理が楽しめるお店。グリーンカレーやパッタイなど、辛さと香り豊かな料理が揃っている。シンプルでアットホームな店内で、タイの味を気軽に楽しめる', '090-1111-1141', '111-1141', 20, '愛知県名古屋市中区栄X-XX-XX', '木', '16:00:00', '24:00:00', 1000, 5);
INSERT IGNORE INTO restaurants (id, name, image_name, description, phone_number, postal_code, capacity, address, holiday, opening_time, closing_time, price, categories_id) VALUES (32, 'タイ料理 バンタイ', 'photo32.jpg', 'バンタイは、タイの屋台風の料理が味わえる店。トムヤムクンやガパオライスなど、本場の味が楽しめる。カジュアルな雰囲気で、ランチにもディナーにもぴったりな場所。', '090-1111-1142', '111-1142', 17, '愛知県名古屋市中区栄X-XX-XX', '木', '15:00:00', '23:00:00', 1600, 5);
INSERT IGNORE INTO restaurants (id, name, image_name, description, phone_number, postal_code, capacity, address, holiday, opening_time, closing_time, price, categories_id) VALUES (33, 'ベトナム料理 フォー屋 りん', 'photo33.jpg', 'りんは、ベトナムの定番料理フォーが自慢のお店。鶏肉や牛肉の旨味がしっかりと染み込んだスープが特徴で、ヘルシーながらも満足感のある一杯が楽しめる。落ち着いた雰囲気で、ゆっくり食事ができる。', '090-1111-1143', '111-1143', 15, '愛知県名古屋市中区栄X-XX-XX', '土', '11:00:00', '23:00:00', 2000, 5);
INSERT IGNORE INTO restaurants (id, name, image_name, description, phone_number, postal_code, capacity, address, holiday, opening_time, closing_time, price, categories_id) VALUES (34, 'ベトナム食堂 アジアの風', 'photo34.jpg', 'アジアの風は、バインミーや生春巻きなど、ベトナム料理を手軽に楽しめる店。新鮮な具材を使い、香草やスパイスが効いた本格的な味わいが楽しめる。カジュアルな雰囲気で、ランチにもぴったりな場所。', '090-1111-1144', '111-1144', 20, '愛知県名古屋市中区栄X-XX-XX', '木', '11:00:00', '23:00:00', 1400, 5);
INSERT IGNORE INTO restaurants (id, name, image_name, description, phone_number, postal_code, capacity, address, holiday, opening_time, closing_time, price, categories_id) VALUES (35, '焼肉いちばん', 'photo35.jpg', 'いちばんは、上質な肉を使った焼肉が楽しめるお店。こだわりのタレとともに、ジューシーな肉を焼いて食べるスタイルが特徴。落ち着いた店内で、家族や友達とゆっくり楽しめる。', '090-1111-1145', '111-1145', 25, '愛知県名古屋市中区栄X-XX-XX', '木', '16:00:00', '24:00:00', 1800, 1);
INSERT IGNORE INTO restaurants (id, name, image_name, description, phone_number, postal_code, capacity, address, holiday, opening_time, closing_time, price, categories_id) VALUES (36, '炭火焼肉牛角', 'photo36.jpg', '牛角は、炭火で焼いた焼肉が自慢の店。豊富なメニューとボリューム満点な盛り付けで、食べ応え抜群。カジュアルな雰囲気で、みんなでワイワイ楽しむのにぴったりな場所。', '090-1111-1146', '111-1146', 10, '愛知県名古屋市中区栄X-XX-XX', '木', '17:00:00', '25:00:00', 1800, 1);
INSERT IGNORE INTO restaurants (id, name, image_name, description, phone_number, postal_code, capacity, address, holiday, opening_time, closing_time, price, categories_id) VALUES (37, '魚料理 魚心', 'photo37.jpg', '魚心は、新鮮な魚を使った定食や刺身が自慢のお店。毎日仕入れる旬の魚を、シンプルに味わえる料理が多い。落ち着いた雰囲気で、ゆっくり食事を楽しめる場所。', '090-1111-1147', '111-1147', 30, '愛知県名古屋市中区栄X-XX-XX', '木', '11:00:00', '23:00:00', 1100, 1);
INSERT IGNORE INTO restaurants (id, name, image_name, description, phone_number, postal_code, capacity, address, holiday, opening_time, closing_time, price, categories_id) VALUES (38, '海鮮料理 鮮魚亭', 'photo38.jpg', '鮮魚亭は、鮮度にこだわった海鮮料理を提供する店。刺身や焼き魚、煮魚などが楽しめ、どの料理も素材の良さが引き立っている。カジュアルな雰囲気で、ランチやディナーに最適な場所。', '090-1111-1148', '111-1148', 20, '愛知県名古屋市中区栄X-XX-XX', '月', '11:00:00', '22:00:00', 1500, 1);
INSERT IGNORE INTO restaurants (id, name, image_name, description, phone_number, postal_code, capacity, address, holiday, opening_time, closing_time, price, categories_id) VALUES (39, 'カフェ ブルーム', 'photo39.jpg', 'ブルームは、落ち着いた雰囲気のカフェで、美味しいコーヒーと自家製スイーツが楽しめる。おしゃれな店内で、ゆっくりとくつろぎながら過ごせる場所。', '090-1111-1149', '111-1149', 15, '愛知県名古屋市中区栄X-XX-XX', '日', '9:00:00', '18:00:00', 900, 7);
INSERT IGNORE INTO restaurants (id, name, image_name, description, phone_number, postal_code, capacity, address, holiday, opening_time, closing_time, price, categories_id) VALUES (40, 'カフェひととき', 'photo40.jpg', 'ひとときは、心地よい空間でリラックスできるカフェ。豊富なドリンクメニューと軽食があり、ひと息つくのにぴったりな場所。友達とのおしゃべりにもおすすめ。', '090-1111-1150', '111-1150', 20, '愛知県名古屋市中区栄X-XX-XX', '火', '8:00:00', '17:00:00', 1000, 7);
INSERT IGNORE INTO restaurants (id, name, image_name, description, phone_number, postal_code, capacity, address, holiday, opening_time, closing_time, price, categories_id) VALUES (41, 'アフタヌーンティーサロン ロイヤルガーデン', 'photo41.jpg', 'ロイヤルガーデンは、優雅な雰囲気で楽しめるアフタヌーンティーの専門店。種類豊富な紅茶とともに、サンドイッチやスコーン、デザートが豪華に並ぶ。ゆったりした時間を過ごしたい時にぴったり。', '090-1111-1151', '111-1151', 15, '愛知県名古屋市中区栄X-XX-XX', '金', '11:00:00', '17:00:00', 3000, 7);
INSERT IGNORE INTO restaurants (id, name, image_name, description, phone_number, postal_code, capacity, address, holiday, opening_time, closing_time, price, categories_id) VALUES (42, 'ティールーム プティ・ボヌール', 'photo42.jpg', 'プティ・ボヌールは、こだわりの紅茶と共に、手作りのスイーツやサンドイッチが楽しめるアフタヌーンティーのお店。落ち着いた空間で、ゆっくりと贅沢なティータイムが過ごせる。', '090-1111-1152', '111-1152', 21, '愛知県名古屋市中区栄X-XX-XX', '月', '11:00:00', '17:00:00', 4000, 7);
INSERT IGNORE INTO restaurants (id, name, image_name, description, phone_number, postal_code, capacity, address, holiday, opening_time, closing_time, price, categories_id) VALUES (43, 'ビュッフェ レストラン グランダイニング', 'photo43.jpg', 'グランダイニングは、種類豊富な料理が並ぶビュッフェスタイルのレストラン。和洋中の料理を好きなだけ楽しめ、デザートやサラダバーも充実している。家族や友達との食事にぴったりな場所。', '090-1111-1153', '111-1153', 50, '愛知県名古屋市中区栄X-XX-XX', '水', '11:00:00', '21:00:00', 2000, 7);
INSERT IGNORE INTO restaurants (id, name, image_name, description, phone_number, postal_code, capacity, address, holiday, opening_time, closing_time, price, categories_id) VALUES (44, 'バイキング フォレストビュッフェ', 'photo44.jpg', 'フォレストビュッフェは、季節ごとの食材を使った料理が楽しめるビュッフェレストラン。温かい料理から冷たい料理まで、バリエーション豊かなメニューが並んでおり、ランチやディナーに最適。', '090-1111-1154', '111-1154', 40, '愛知県名古屋市中区栄X-XX-XX', '木', '11:00:00', '20:00:00', 1800, 7);
INSERT IGNORE INTO restaurants (id, name, image_name, description, phone_number, postal_code, capacity, address, holiday, opening_time, closing_time, price, categories_id) VALUES (45, '金シャチたこ焼き', 'photo45.jpg', '名古屋名物を手軽に楽しめるたこ焼き店。金シャチを模したユニークな形のたこ焼きが特徴で、外はカリッと、中はとろっとした食感が絶品。地元のソースと特製スパイスを使い、味にこだわった一品を提供', '090-1111-1155', '111-1155', 10, '愛知県名古屋市中区栄X-XX-XX', '木', '16:00:00', '25:00:00', 1100, 1);
INSERT IGNORE INTO restaurants (id, name, image_name, description, phone_number, postal_code, capacity, address, holiday, opening_time, closing_time, price, categories_id) VALUES (46, '名古屋鉄板たこ焼き', 'photo46.jpg', '鉄板で提供されるアツアツのたこ焼きが自慢の店。シンプルながら、カリッとした外側ととろりとした中身が絶妙。名古屋名物の手羽先とのセットメニューもあり、地元民にも観光客にも人気のスポットです。', '090-1111-1156', '111-1156', 30, '愛知県名古屋市中区栄X-XX-XX', '木', '15:00:00', '23:00:00', 1000, 1);
INSERT IGNORE INTO restaurants (id, name, image_name, description, phone_number, postal_code, capacity, address, holiday, opening_time, closing_time, price, categories_id) VALUES (47, 'タコスキング名古屋', 'photo47.jpg', '名古屋で人気のタコス専門店。スパイシーなソースとジューシーな具材がたっぷり詰まったタコスが絶品。トッピングも自由自在で、自分好みの一品が楽しめる。テイクアウトにもぴったりなカジュアルなお店。', '090-1111-1157', '111-1157', 30, '愛知県名古屋市中区栄X-XX-XX', '日', '10:00:00', '23:00:00', 1100, 6);
INSERT IGNORE INTO restaurants (id, name, image_name, description, phone_number, postal_code, capacity, address, holiday, opening_time, closing_time, price, categories_id) VALUES (48, 'メキシカンタコス屋', 'photo48.jpg', '本格メキシカンを楽しめるお店。タコスはもちろん、タコスボウルやナチョスなども充実。新鮮な野菜とお肉を使ったヘルシーでボリューム満点な料理が自慢。ランチにもディナーにもおすすめなカジュアルなスポット。', '090-1111-1158', '111-1158', 25, '愛知県名古屋市中区栄X-XX-XX', '木', '11:00:00', '24:00:00', 1200, 6);
INSERT IGNORE INTO restaurants (id, name, image_name, description, phone_number, postal_code, capacity, address, holiday, opening_time, closing_time, price, categories_id) VALUES (49, 'バル・エル・ソル', 'photo49.jpg', '名古屋の街中にある本格スペインバル。自家製のパエリアやタパスが人気で、ワインとの相性も抜群。アットホームな雰囲気で、友達や同僚と気軽に立ち寄れる。週末はライブ演奏も楽しめることがある。', '090-1111-1159', '111-1159', 35, '愛知県名古屋市中区栄X-XX-XX', '木', '11:00:00', '24:00:00', 2500, 5);
INSERT IGNORE INTO restaurants (id, name, image_name, description, phone_number, postal_code, capacity, address, holiday, opening_time, closing_time, price, categories_id) VALUES (50, 'タパス・ラ・ヴィーダ', 'photo50.jpg', '本格的なスペイン料理を楽しめるお店。特にシーフードパエリアやサングリアが絶品。落ち着いた雰囲気の店内で、ゆっくり食事を楽しみたい人にぴったり。スペイン直輸入の食材を使った料理が特徴。', '090-1111-1160', '111-1160', 20, '愛知県名古屋市中区栄X-XX-XX', '木', '13:00:00', '20:00:00', 3000, 5);

-- rolesテーブル
INSERT IGNORE INTO roles (id, name) VALUES (1, 'ROLE_GENERAL');
INSERT IGNORE INTO roles (id, name) VALUES (2, 'PREMIUM_MEMBER');
INSERT IGNORE INTO roles (id, name) VALUES (3, 'ROLE_ADMIN');

-- usersテーブル
INSERT IGNORE INTO users (id, name, furigana, postal_code, address, phone_number, email, password, role_id, enabled) VALUES (1, '山田 太郎', 'ヤマダ タロウ', '101-0022', '東京都千代田区神田練塀町300番地', '090-1234-5678', 'taro.nagoyameshi@example.com', '$2a$10$2JNjTwZBwo7fprL2X4sv.OEKqxnVtsVQvuXDkI8xVGix.U3W5B7CO', 1, true);
INSERT IGNORE INTO users (id, name, furigana, postal_code, address, phone_number, email, password, role_id, enabled) VALUES (2, '山田 花子', 'ヤマダ ハナコ', '101-0022', '東京都千代田区神田練塀町300番地', '090-1234-5678', 'hanako.nagoyameshi@example.com', '$2a$10$2JNjTwZBwo7fprL2X4sv.OEKqxnVtsVQvuXDkI8xVGix.U3W5B7CO', 2, true);
INSERT IGNORE INTO users (id, name, furigana, postal_code, address, phone_number, email, password, role_id, enabled) VALUES (3, '山田　義勝', 'ヤマダ ヨシカツ', '638-0644', '奈良県五條市西吉野町湯川X-XX-XX', '090-1234-5678', 'yoshikatsu.nagoyameshi@example.com', '$2a$10$2JNjTwZBwo7fprL2X4sv.OEKqxnVtsVQvuXDkI8xVGix.U3W5B7CO', 3, true);
INSERT IGNORE INTO users (id, name, furigana, postal_code, address, phone_number, email, password, role_id, enabled) VALUES (4, '山田 幸美', 'ヤマダ サチミ', '342-0006', '埼玉県吉川市南広島X-XX-XX', '090-1234-5678', 'sachimi.nagoyameshi@example.com', 'password', 1, false);
INSERT IGNORE INTO users (id, name, furigana, postal_code, address, phone_number, email, password, role_id, enabled) VALUES (5, '山田 雅', 'ヤマダ ミヤビ', '527-0209', '滋賀県東近江市佐目町X-XX-XX', '090-1234-5678', 'miyabi.nagoyameshi@example.com', 'password', 1, false);
INSERT IGNORE INTO users (id, name, furigana, postal_code, address, phone_number, email, password, role_id, enabled) VALUES (6, '山田 正保', 'ヤマダ マサヤス', '989-1203', '宮城県柴田郡大河原町旭町X-XX-XX', '090-1234-5678', 'masayasu.nagoyameshi@example.com', 'password', 1, false);
INSERT IGNORE INTO users (id, name, furigana, postal_code, address, phone_number, email, password, role_id, enabled) VALUES (7, '山田 真由美', 'ヤマダ マユミ', '951-8015', '新潟県新潟市松岡町X-XX-XX', '090-1234-5678', 'mayumi.nagoyameshi@example.com', 'password', 1, false);
INSERT IGNORE INTO users (id, name, furigana, postal_code, address, phone_number, email, password, role_id, enabled) VALUES (8, '山田 安民', 'ヤマダ ヤスタミ', '241-0033', '神奈川県横浜市旭区今川町X-XX-XX', '090-1234-5678', 'yasutami.nagoyameshi@example.com', 'password', 1, false);
INSERT IGNORE INTO users (id, name, furigana, postal_code, address, phone_number, email, password, role_id, enabled) VALUES (9, '山田 章緒', 'ヤマダ アキオ', '739-2103', '広島県東広島市高屋町宮領X-XX-XX', '090-1234-5678', 'akio.nagoyameshi@example.com', 'password', 1, false);
INSERT IGNORE INTO users (id, name, furigana, postal_code, address, phone_number, email, password, role_id, enabled) VALUES (10, '山田 祐子', 'ヤマダ ユウコ', '601-0761', '京都府南丹市美山町高野X-XX-XX', '090-1234-5678', 'yuko.nagoyameshi@example.com', 'password', 1, false);
INSERT IGNORE INTO users (id, name, furigana, postal_code, address, phone_number, email, password, role_id, enabled) VALUES (11, '山田 秋美', 'ヤマダ アキミ', '606-8235', '京都府京都市左京区田中西春菜町X-XX-XX', '090-1234-5678', 'akimi.nagoyameshi@example.com', 'password', 1, false);
INSERT IGNORE INTO users (id, name, furigana, postal_code, address, phone_number, email, password, role_id, enabled) VALUES (12, '山田 信平', 'ヤマダ シンペイ', '673-1324', '兵庫県加東市新定X-XX-XX', '090-1234-5678', 'shinpei.nagoyameshi@example.com', 'password', 1, false);

--campanyテーブル
INSERT IGNORE INTO company (id, name, address, representative, capital, establishment, business, number_of_employees) VALUES (1, 'NAGOYAMESHI株式会社', '〒101-0022 東京都千代田区神田町12345ビル', '山田春', '1億円','2020年8月31日','飲食店の情報提供サービス', 100);


--reservationsテーブル
INSERT IGNORE INTO reservations (id, restaurant_id, user_id, reserved_date, reserved_time, number_of_people) VALUES (1, 1, 1, '2023-04-01','15:00:00',2);
INSERT IGNORE INTO reservations (id, restaurant_id, user_id, reserved_date, reserved_time, number_of_people) VALUES (2, 2, 1, '2023-04-01','12:00:00', 3);
INSERT IGNORE INTO reservations (id, restaurant_id, user_id, reserved_date, reserved_time, number_of_people) VALUES (3, 3, 1, '2023-04-01','13:00:00', 5);
INSERT IGNORE INTO reservations (id, restaurant_id, user_id, reserved_date, reserved_time, number_of_people) VALUES (4, 4, 1, '2023-04-01','14:00:00', 5);
INSERT IGNORE INTO reservations (id, restaurant_id, user_id, reserved_date, reserved_time, number_of_people) VALUES (5, 5, 1, '2023-04-01','16:00:00', 4);
INSERT IGNORE INTO reservations (id, restaurant_id, user_id, reserved_date, reserved_time, number_of_people) VALUES (6, 6, 1, '2023-04-01','18:00:00', 3);
INSERT IGNORE INTO reservations (id, restaurant_id, user_id, reserved_date, reserved_time, number_of_people) VALUES (7, 7, 1, '2023-04-01','19:00:00',4);
INSERT IGNORE INTO reservations (id, restaurant_id, user_id, reserved_date, reserved_time, number_of_people) VALUES (8, 8, 1, '2023-04-01','16:00:00',5);
INSERT IGNORE INTO reservations (id, restaurant_id, user_id, reserved_date, reserved_time, number_of_people) VALUES (9, 9, 1, '2023-04-01','13:00:00',2);
INSERT IGNORE INTO reservations (id, restaurant_id, user_id, reserved_date, reserved_time, number_of_people) VALUES (10, 10, 1, '2023-04-01','19:00:00',3);
INSERT IGNORE INTO reservations (id, restaurant_id, user_id, reserved_date, reserved_time, number_of_people) VALUES (11, 11, 1, '2023-04-01','20:00:00',3);
