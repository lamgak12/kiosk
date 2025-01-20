# 🎯키오스크 프로젝트

## 과제소개

- 학습한 내용을 바탕으로 키오스크 프로그램을 구현하세요.
- M사, K사, L사와 같은 패스트푸드 음식점에 가면 있는 키오스크 기계의 기능과 비슷하게 구현해보세요
- CLI 기반으로 콘솔에 데이터 입력 및 결과가 출력됩니다.
- 레벨은 필수 과제 레벨 1~5까지, 도전 과제 2가지가 있습니다.
  
## 레벨별 필수 기능

| **레벨**   | **필수 기능**                                                                 |
|-----------|--------------------------------------------------------------------------------|
| **Lv 1**   | 1. 햄버거 메뉴 출력 및 선택하기                                                 |
|           | 2. 메뉴 출력 후 선택한 번호에 따른 로직 실행                                    |
|           | 3. 프로그램 종료 기능                                                           |
|           | 4. 유효한 입력 처리 및 오류 처리                                                |
| **Lv 2**   | 1. MenuItem 클래스를 사용하여 햄버거 메뉴 관리                                  |
|           | 2. List<MenuItem>을 사용하여 메뉴 목록 출력                                     |
|           | 3. 숫자 입력에 따른 메뉴 선택                                                  |
|           | 4. 프로그램 종료 기능                                                           |
| **Lv 3**   | 1. Kiosk 클래스를 생성하여 메뉴 및 사용자 입력 처리 관리                       |
|           | 2. List<MenuItem>을 Menu 클래스에서 관리                                         |
|           | 3. 메뉴 선택 후 상세 메뉴 출력 및 유효성 검사                                  |
| **Lv 4**   | 1. Menu 클래스 생성하여 MenuItem 객체 관리                                      |
|           | 2. 메뉴 카테고리 출력 (예: Burgers, Drinks, Desserts)                           |
|           | 3. 사용자가 선택한 메뉴 출력                                                   |
|           | 4. 메뉴 상세 선택 후 출력 및 장바구니 관리                                      |
| **Lv 5**   | 1. MenuItem, Menu, Kiosk 클래스의 필드에 캡슐화 적용                           |
|           | 2. Getter 및 Setter 메서드를 사용하여 데이터 접근 및 수정 관리                 |
| **Lv 1 도전** | 1. 장바구니 생성 및 관리 기능                                                  |
|           | 2. 장바구니에 메뉴 추가 및 출력 기능                                            |
|           | 3. 금액 계산 및 장바구니 출력                                                  |
|           | 4. 잘못된 선택 시 예외 처리                                                    |
| **Lv 2 도전** | 1. Enum을 사용하여 사용자 유형별 할인율 적용                                  |
|           | 2. 람다 & 스트림을 활용하여 장바구니 조회 및 특정 메뉴 제거 기능               |
|           | 3. 주문 및 장바구니 처리 개선                                                   |


# 레벨별 필수 기능 및 구현 여부

| **레벨**   | **필수 기능**                                                                | **구현 여부** |
|-----------|--------------------------------------------------------------------------|:---------:|
| **Lv 1**   | 1. 햄버거 메뉴 출력 및 선택하기                                                      |     ✔     |
|           | 2. 메뉴 출력 후 선택한 번호에 따른 로직 실행                                              |     ✔     |
|           | 3. 프로그램 종료 기능                                                            |     ✔     |
|           | 4. 유효한 입력 처리 및 오류 처리                                                     |     ✔     |
| **Lv 2**   | 1. MenuItem 클래스를 사용하여 햄버거 메뉴 관리                                          |     ✔     |
|           | 2. List<MenuItem>을 사용하여 메뉴 목록 출력                                         |     ✔     |
|           | 3. 숫자 입력에 따른 메뉴 선택                                                       |     ✔     |
|           | 4. 프로그램 종료 기능                                                            |     ✔     |
| **Lv 3**   | 1. Kiosk 클래스를 생성하여 메뉴 및 사용자 입력 처리 관리                                     |     ✔     |
|           | 2. List<MenuItem>을 Menu 클래스에서 관리                                         |     ✔     |
|           | 3. 메뉴 선택 후 상세 메뉴 출력 및 유효성 검사                                             |     ✔     |
| **Lv 4**   | 1. Menu 클래스 생성하여 MenuItem 객체 관리                                          |     ✔     |
|           | 2. 메뉴 카테고리 출력 (예: Burgers, Drinks, Desserts)                             |     ✔     |
|           | 3. 사용자가 선택한 메뉴 출력                                                        |     ✔     |
|           | 4. 메뉴 상세 선택 후 출력 및 장바구니 관리                                               |     ✔     |
| **Lv 5**   | 1. MenuItem, Menu, Kiosk 클래스의 필드에 캡슐화 적용                                 |     ✔     |
|           | 2. Getter 및 Setter 메서드를 사용하여 데이터 접근 및 수정 관리                              |     ✔     |
| **Lv 1 도전🎯** | 1. 장바구니 생성 및 관리 기능                                                       |     ✔     |
|           | 2. 장바구니에 메뉴 추가 및 출력 기능                                                   |     ✔     |
|           | 3. 금액 계산 및 장바구니 출력                                                       |     ✔     |
|           | 4. 잘못된 선택 시 예외 처리                                                        |     ✔     |
| **Lv 2 도전🎯** | 1. Enum을 사용하여 사용자 유형별 할인율 적용                                             |     ✔     |
|           | 2. 람다 & 스트림을 활용하여 장바구니 조회 및 특정 메뉴 제거 기능                                  |     ❌      |
|           | 3. 주문 및 장바구니 처리 개선                                                       |     △     |

## 개발 기간 및 도구
### 개발 기간 : 2025.01.13 ~ 2025.01.20
### 개발 도구
- 사용 언어 : Java JDK 17
- 빌드 도구 : gradle
- 개발 환경 : IntelliJ IDEA
- 버전 관리 : git, github
## 프로젝트 구조

```
kiosk🏪
└── src📁
    └── com📁
       └── example📁
           ├── kiosk1📁
           │   └── Main☕
           ├── kiosk2📁
           │   ├── Main☕
           │   └── MenuItem☕
           ├── kiosk3📁
           │   ├── Kiosk☕
           │   ├── Main☕
           │   └── MenuItem☕
           ├── kiosk4📁
           │   ├── Kiosk☕
           │   ├── Main☕
           │   ├── Menu☕
           │   └── MenuItem☕
           └── kiosk5📁
               ├── Cart☕
               ├── CartItem☕
               ├── DiscountType☕
               ├── Kiosk☕
               ├── Main☕
               ├── Menu☕
               └── MenuItem☕
```

## 클래스 다이어그램

![클래스다이어그램](https://github.com/user-attachments/assets/3d0dba2f-0c45-4d79-94e5-fd6a7dd12349)


## 플로우 차트

![플로우차트](https://github.com/user-attachments/assets/d1ba10ff-854b-458b-827f-08e6b8263b05)


## 주요 메서드 설명


### 1. `Menu` 클래스
#### `addMenuItem(MenuItem menuItem)`
- 메뉴 항목을 `menuItems` 리스트에 추가하는 메서드입니다.

#### `getMenuItems()`
- 현재 메뉴의 항목 리스트를 반환하는 메서드입니다.


### 2. `Cart` 클래스
#### `addCart(MenuItem menuItem, int quantity)`
- 특정 `MenuItem`을 장바구니에 추가하거나 이미 있는 경우 수량을 증가시키는 메서드입니다.

#### `removeCartItem(int index, int quantity)`
- 장바구니에서 특정 항목을 수량만큼 제거하거나 완전히 삭제하는 메서드입니다.

#### `printCart()`
- 장바구니의 모든 항목과 총액을 출력하는 메서드입니다.

#### `getTotalPrice()`
- 장바구니의 총액을 계산하여 반환하는 메서드입니다.

#### `calculateTotalPrice()`
- 장바구니의 총액을 계산하여 반환하는 메서드입니다.

### 3. `CartItem` 클래스
#### `getSubTotalPrice()`
- 해당 항목의 총액(단가 * 수량)을 계산하여 반환하는 메서드입니다.

### 4. `DiscountType` 클래스
#### `applyDiscount(double totalPrice)`
- 주어진 총액에 할인율을 적용하여 최종 가격을 계산하는 메서드입니다.
#### `printDiscountType()`
- 모든 할인 유형을 출력하는 메서드입니다.


### 5. `Kiosk` 클래스



#### `handleSubMenu(Menu selectedMenu)`
- 선택된 메뉴의 서브 메뉴를 처리하는 메서드입니다.

#### `displayList(String name, List<T> list)`
- 특정 이름과 항목 리스트를 출력하는 메서드입니다.

#### `getValidInput(List<T> list, String prompt, boolean allowZero)`
- 유효한 입력을 받기 위해 범위 검증 및 예외 처리를 수행하며, 잘못된 입력은 계속해서 요청합니다. 
- allowZero는 0번 입력을 허용할지 여부를 결정합니다.
- 장바구니에 아이템이 있을 때와 없을때를 구분하여 입력 값을 검증합니다.
#### `orderConfirmation()`
- 장바구니의 내용을 출력하고, 결제 및 할인 적용을 확인하는 메서드입니다.
- 주문이 완료되면 메인 메뉴로 넘어갑니다.
#### `handleCancelOrder()`
- 장바구니에서 선택한 항목 개수를 감소하거나 제거할 때 입력 값을 검증하고 `removeCartItem` 인자 값을 넘겨줍니다.





## 구현 결과
### 아이템 구매 (장바구니 추가, 할인, 구매완료)
![흐름1](https://github.com/user-attachments/assets/6b4ec7a6-e4f6-48e3-a63e-403abda889f6)  
![흐름2](https://github.com/user-attachments/assets/0b27adaf-4784-4498-b1fd-585a7bab3df6)

### 아이템 구매 취소 (개수 감소)
![구매취소1](https://github.com/user-attachments/assets/354d9e33-98ef-44b0-b91f-a4b7f6b8fef8)  
![구매취소2](https://github.com/user-attachments/assets/6e44d9c0-b62d-4b7e-afc5-ee35944b9b7e)  
![구매취소3](https://github.com/user-attachments/assets/f9e87bdc-f87d-4610-a970-7364fc36a384)

### 아이템 구매 취소 (장바구니에서 삭제)
![구매취소4](https://github.com/user-attachments/assets/8a50aa57-5075-48e4-bf25-7838bbd0cd3e)

### 검증
#### 메인 메뉴
![메인메뉴 검증1](https://github.com/user-attachments/assets/25eb40d3-acf3-44f6-8d6c-6641db945254)

#### 서브 메뉴
![서브메뉴 검증](https://github.com/user-attachments/assets/f9fa6f6d-f597-4542-8fb9-64db7fcf1225)

#### 장바구니 추가 전
![장바구니 추가전 검증1](https://github.com/user-attachments/assets/12819601-5f2c-4af0-bfec-bf765f8d2df5)  
![장바구니 추가전 검증2](https://github.com/user-attachments/assets/cad23721-a74c-4780-9912-111e94e6b29d)

#### 주문 전
![주문전 검증](https://github.com/user-attachments/assets/4dc61b66-7bf3-4437-ac19-a6477c29965e)

#### 주문 후 할인 전
![주문후 할인전 검증](https://github.com/user-attachments/assets/a92a148c-e230-4c80-b21f-33e3ffc9e819)
### 주문 취소 전 검증
![주문취소전 검증1](https://github.com/user-attachments/assets/b6d8abd9-9728-4141-a9d1-c00c7062fbca)  
![주문취소전 검증2](https://github.com/user-attachments/assets/d7de96d5-3a0a-46ad-9f66-52bd332ee309)


## 잘했다고 생각하는 점
주어진 시간 동안 최대한 구현하려고 노력한 점을 자찬합니다.  

## 아쉬운 점
처음 설계 방향을 복잡하게 잡아서 로직이 복잡한 코드가 나오게 됐습니다.
여러가지 상황을 고려하며 코드를 작성해야 함을 반성합니다.
