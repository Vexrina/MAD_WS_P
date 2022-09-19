import httpx as h
MAIN_URL = 'http://localhost:8080/'

def register(login, password, email, phone_number):
    data = {'login':login, 'password':password, 'email':email, 'phone_number':phone_number}
    r = h.post(MAIN_URL+'register', json=data)
    print(r.status_code)
    print(r.json())

# register('l', 'p', 'e', 'p')

def login(email, password):
    data = {'login':email, 'password':password}
    r = h.post(MAIN_URL+'login', json=data)
    print(r.status_code)
    print(r.json())

# login('l','p')

# def menu_create(name, price, path_to_image, category):  #TODO
#     img = []
#     with Image(filename=path_to_image) as image:
#         img.append(img.append(image.channel_images))
#     data = {'name':name, 'price':price, 'image':img, 'category':category}
#     r = h.post(MAIN_URL+'menu/create', json=data)
#     print(r.status_code)
#     print(r.json())

# menu_create('test', '3.00', ??, '3')
