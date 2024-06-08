const names = [
  "훈련하는군돌이",
  "경계하는군돌이",
  "복귀하는군돌이",
  "출타하는군돌이",
  "점호받는군돌이",
  "정비하는군돌이",
  "사격하는군돌이",
  "전술훈련하는군돌이",
  "야간행군하는군돌이",
  "구보하는군돌이",
  "침투하는군돌이",
  "은신하는군돌이",
  "경비하는군돌이",
  "지휘하는군돌이",
  "보고하는군돌이",
  "통신하는군돌이",
  "의무훈련하는군돌이",
  "수류탄던지는군돌이",
  "철조망설치하는군돌이",
  "도하훈련하는군돌이",
  "진지구축하는군돌이",
  "헬기탑승하는군돌이",
  "탱크운전하는군돌이",
  "전차정비하는군돌이",
  "대공사격하는군돌이",
  "야전의무훈련하는군돌이",
  "화생방훈련하는군돌이",
  "지뢰제거하는군돌이",
  "항공정찰하는군돌이",
  "유도탄발사하는군돌이",
  "잠수훈련하는군돌이",
  "수중폭파하는군돌이",
  "야전취사하는군돌이",
  "야외숙영하는군돌이",
  "방공훈련하는군돌이",
  "장비운용하는군돌이",
  "탄약보급하는군돌이",
  "비상대기하는군돌이",
  "유격훈련하는군돌이",
  "장비점검하는군돌이",
  "작전회의하는군돌이",
  "병력동원하는군돌이",
  "군사정보수집하는군돌이",
  "군사훈련하는군돌이",
  "군기교육하는군돌이",
  "전술지도보는군돌이",
  "전투복착용하는군돌이",
  "군화닦는군돌이",
  "군용차량운전하는군돌이",
  "탄약장전하는군돌이",
  "화력지원요청하는군돌이",
  "공수훈련하는군돌이",
  "무전교신하는군돌이",
  "공중강습하는군돌이",
  "폭탄투하하는군돌이",
  "전방감시하는군돌이",
  "잠복근무하는군돌이",
  "포병사격하는군돌이",
  "전방초소근무하는군돌이",
  "탄약운반하는군돌이",
  "구급처치하는군돌이",
  "사단장시찰하는군돌이",
  "연대장점검하는군돌이",
  "소대원훈련하는군돌이",
  "소대장보고하는군돌이",
  "군기지방문하는군돌이",
  "군수품검사하는군돌이",
  "비상탈출훈련하는군돌이",
  "조종사훈련하는군돌이",
  "격납고정비하는군돌이",
  "군사용드론조작하는군돌이",
  "보급품분배하는군돌이",
  "야전병원운영하는군돌이",
  "포상수여받는군돌이",
  "군기지청소하는군돌이",
  "군사기밀보호하는군돌이",
  "정보전하는군돌이",
  "사이버전훈련하는군돌이",
  "군사작전계획하는군돌이",
  "심리전하는군돌이",
  "통신장비설치하는군돌이",
  "공병작업하는군돌이",
  "군용항공기정비하는군돌이",
  "군사훈련기획하는군돌이",
  "지휘통제하는군돌이",
  "전투지원하는군돌이",
  "적군포로심문하는군돌이",
  "전투병지원하는군돌이",
  "야전탐색하는군돌이",
  "군사용로봇운용하는군돌이",
  "적진침투하는군돌이",
  "군사훈련평가하는군돌이",
  "전쟁시뮬레이션하는군돌이",
  "군수지원하는군돌이",
  "전투복세탁하는군돌이",
  "총기청소하는군돌이",
  "탄약정비하는군돌이",
  "군사분계선감시하는군돌이",
  "군사통신훈련하는군돌이",
  "군용장비점검하는군돌이",
  "보급품운반하는군돌이",
  "군사훈련보고하는군돌이",
  "포대점검하는군돌이",
  "무기체계점검하는군돌이",
  "군사훈련참여하는군돌이",
];

function getRandomName() {
  const randomIndex = Math.floor(Math.random() * names.length);
  return names[randomIndex];
}

function setupName() {
  const name = document.getElementById("nickname");
  name.value = getRandomName() + getRandomNumber();
}
function getRandomNumber() {
  return Math.floor(Math.random() * 10000) + 1;
}

document.addEventListener('DOMContentLoaded', function() {
  const phoneInput = document.getElementById("phone-input");
  const militaryIdInput = document.getElementById("militaryIdInput");
  const passwordInput = document.getElementById("password");
  const passwordCheckInput = document.getElementById("password-check");
  const nicknameInput = document.getElementById("nickname");
  const nextBtn = document.getElementById("nextBtn");

  const passwordErrorMessage = document.getElementById("pw-error-message");
  const passwordCheckErrorMessage = document.getElementById("pwc-error-message");

  function checkInputs() {
      const allFieldsFilled =
          phoneInput.value.trim() !== "" &&
          militaryIdInput.value.trim() !== "" &&
          passwordInput.value.trim() !== "" &&
          passwordCheckInput.value.trim() !== "" &&
          nicknameInput.value.trim() !== "";

      const passwordsMatch = passwordInput.value === passwordCheckInput.value;

      if (allFieldsFilled && passwordsMatch) {
          nextBtn.disabled = false;
          nextBtn.classList.remove("disabled");
          nextBtn.classList.add("abled");
          passwordErrorMessage.classList.add("hidden");
          passwordCheckErrorMessage.classList.add("hidden");
      } else {
          nextBtn.disabled = true;
          nextBtn.classList.remove("abled");
          nextBtn.classList.add("disabled");

          if (!passwordsMatch) {
              passwordCheckErrorMessage.textContent = "비밀번호가 일치하지 않습니다.";
              passwordCheckErrorMessage.classList.remove("hidden");
          } else {
              passwordCheckErrorMessage.classList.add("hidden");
          }
      }
  }

  // 각 입력 필드에 이벤트 리스너를 추가합니다.
  phoneInput.addEventListener("input", checkInputs);
  militaryIdInput.addEventListener("input", checkInputs);
  passwordInput.addEventListener("input", checkInputs);
  passwordCheckInput.addEventListener("input", checkInputs);
  nicknameInput.addEventListener("input", checkInputs);

  // 초기 상태에서 버튼을 비활성화합니다.
  checkInputs();
});

document.addEventListener("DOMContentLoaded", function () {
  const nextBtn = document.getElementById("nextBtn");

  if (nextBtn) {
    nextBtn.addEventListener("click", function () {
      console.log("ee");
      const additionalContent = document.getElementById("additionalContent");
      const nextButton = document.getElementById("nextBtn");
      additionalContent.innerHTML = `
      <div class="mt-8 mx-4 gap-1 flex flex-col border-b group border-[#E6E6E7]">
        <p class="text-[14px] font-medium">인증 번호</p>
        <div class="flex justify-between">
          <input
            type="text"
            placeholder="인증번호를 입력해주세요."
            class="py-2 placeholder:text-[#BABABA] placeholder:text-[16px] group-focus:border-[#DC5788] focus:outline-none"
          />
          <button id="retryBtn" type="button" class="w-[74px] h-[56px] rounded-lg text-[#FFFFFF] text-[14px] p-4 abled">
            재전송
          </button>
        </div>
        <span id="error-message" class="error text-[#E53E3E] text-[12px]"></span>
      </div>
      `;

      const additionalIdentityButton = document.getElementById(
          "additional-identity-button"
      );

      additionalIdentityButton.classList.remove('hidden');
      nextButton.classList.add('hidden');

      additionalIdentityButton.innerHTML = `
          <div class="w-full flex place-items-baseline justify-center mt-auto mb-2">
            <button
              id="identity-button"
              type="submit"
              class="w-full mx-4 p-4 rounded-md text-[#FFFFFF] text-[15px] abled"
            >
              회원가입
            </button>
          </div>
      `;
    });
  }
});

