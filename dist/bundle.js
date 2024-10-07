/*
 * ATTENTION: The "eval" devtool has been used (maybe by default in mode: "development").
 * This devtool is neither made for production nor for readable output files.
 * It uses "eval()" calls to create a separate source file in the browser devtools.
 * If you are trying to read the output file, select a different devtool (https://webpack.js.org/configuration/devtool/)
 * or disable the default devtool with "devtool: false".
 * If you are looking for production-ready output files, see mode: "production" (https://webpack.js.org/configuration/mode/).
 */
/******/ (() => { // webpackBootstrap
/******/ 	"use strict";
/******/ 	var __webpack_modules__ = ({

/***/ "./src/index.ts":
/*!**********************!*\
  !*** ./src/index.ts ***!
  \**********************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

eval("__webpack_require__.r(__webpack_exports__);\n/* harmony import */ var _utils_game__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./utils/game */ \"./src/utils/game.ts\");\n/* harmony import */ var _utils_updateGameMessage__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./utils/updateGameMessage */ \"./src/utils/updateGameMessage.ts\");\n\n\n// Dom과 연결\nconst form = document.querySelector('form');\nconst userInput = document.getElementById('userInput');\nconst result = document.getElementById('result');\nconst game = (0,_utils_game__WEBPACK_IMPORTED_MODULE_0__.createGame)();\nlet isViewingRecords = false;\nform.addEventListener('submit', (e) => {\n    e.preventDefault();\n    handleUserInput(userInput.value.trim());\n});\nconst handleUserInput = (input) => {\n    if (isViewingRecords) {\n        const detail = game.getDetailGameRecords(Number(input));\n        (0,_utils_updateGameMessage__WEBPACK_IMPORTED_MODULE_1__.updateGameMessage)(result, detail);\n        userInput.value = '';\n        isViewingRecords = false;\n        return;\n    }\n    switch (input) {\n        case '1':\n            startGame();\n            break;\n        case '2':\n            showGameRecords();\n            break;\n        case '3':\n            showTotalGameRecords();\n            break;\n        case '9':\n            endGame();\n            break;\n        default:\n            if (game.getIsGameStarted()) {\n                (0,_utils_updateGameMessage__WEBPACK_IMPORTED_MODULE_1__.updateGameMessage)(result, game.checkNum(input));\n                return (userInput.value = '');\n            }\n            (0,_utils_updateGameMessage__WEBPACK_IMPORTED_MODULE_1__.updateGameMessage)(result, '게임을 시작하려면 먼저 1을 입력해주세요.');\n    }\n};\nconst startGame = () => {\n    game.startGame();\n    (0,_utils_updateGameMessage__WEBPACK_IMPORTED_MODULE_1__.updateGameMessage)(result, '컴퓨터가 숫자를 뽑았습니다');\n    userInput.value = '';\n};\nconst endGame = () => {\n    game.resetGame();\n    (0,_utils_updateGameMessage__WEBPACK_IMPORTED_MODULE_1__.updateGameMessage)(result, '애플리케이션이 종료되었습니다.');\n    userInput.value = '';\n};\nconst showGameRecords = () => {\n    const records = game.getGameRecords();\n    let message = '게임 기록:\\n';\n    records.forEach((record) => {\n        message += `[${record.id}] / 시작시간: ${record.start} / 종료시간: ${record.end} / 횟수: ${record.attempt}\\n`;\n    });\n    (0,_utils_updateGameMessage__WEBPACK_IMPORTED_MODULE_1__.updateGameMessage)(result, message);\n    isViewingRecords = true;\n    userInput.value = '';\n};\nconst showTotalGameRecords = () => {\n    (0,_utils_updateGameMessage__WEBPACK_IMPORTED_MODULE_1__.updateGameMessage)(result, game.getTotalListRecords());\n};\n\n\n//# sourceURL=webpack:///./src/index.ts?");

/***/ }),

/***/ "./src/utils/compareNumbers.ts":
/*!*************************************!*\
  !*** ./src/utils/compareNumbers.ts ***!
  \*************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

eval("__webpack_require__.r(__webpack_exports__);\n/* harmony export */ __webpack_require__.d(__webpack_exports__, {\n/* harmony export */   compareNumbers: () => (/* binding */ compareNumbers)\n/* harmony export */ });\nconst compareNumbers = (randomNumber, num) => {\n    let strike = 0;\n    let ball = 0;\n    [...num].forEach((element, index) => {\n        if (randomNumber.includes(element)) {\n            ball++;\n        }\n        if (element === randomNumber[index]) {\n            strike++;\n        }\n    });\n    return { strike, ball };\n};\n\n\n//# sourceURL=webpack:///./src/utils/compareNumbers.ts?");

/***/ }),

/***/ "./src/utils/formatDate.ts":
/*!*********************************!*\
  !*** ./src/utils/formatDate.ts ***!
  \*********************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

eval("__webpack_require__.r(__webpack_exports__);\n/* harmony export */ __webpack_require__.d(__webpack_exports__, {\n/* harmony export */   formatDate: () => (/* binding */ formatDate)\n/* harmony export */ });\nconst formatDate = (date) => {\n    const year = date.getFullYear();\n    const month = String(date.getMonth() + 1).padStart(2, '0');\n    const day = String(date.getDate()).padStart(2, '0');\n    const hours = String(date.getHours()).padStart(2, '0');\n    const minutes = String(date.getMinutes()).padStart(2, '0');\n    return `${year}. ${month}. ${day} ${hours}:${minutes}`;\n};\n\n\n//# sourceURL=webpack:///./src/utils/formatDate.ts?");

/***/ }),

/***/ "./src/utils/game.ts":
/*!***************************!*\
  !*** ./src/utils/game.ts ***!
  \***************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

eval("__webpack_require__.r(__webpack_exports__);\n/* harmony export */ __webpack_require__.d(__webpack_exports__, {\n/* harmony export */   createGame: () => (/* binding */ createGame)\n/* harmony export */ });\n/* harmony import */ var _compareNumbers__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./compareNumbers */ \"./src/utils/compareNumbers.ts\");\n/* harmony import */ var _formatDate__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./formatDate */ \"./src/utils/formatDate.ts\");\n/* harmony import */ var _randomNumber__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./randomNumber */ \"./src/utils/randomNumber.ts\");\n\n\n\nconst createGame = () => {\n    // 게임 상태\n    let randomNumber = [];\n    let chances = 3;\n    let isGameStarted = false;\n    let gameRecord = [];\n    //  게임 시작\n    const startGame = () => {\n        randomNumber = (0,_randomNumber__WEBPACK_IMPORTED_MODULE_2__.generateRandomNum)();\n        chances = 3;\n        isGameStarted = true;\n        const game = {\n            id: gameRecord.length + 1,\n            start: (0,_formatDate__WEBPACK_IMPORTED_MODULE_1__.formatDate)(new Date()),\n            end: undefined,\n            attempt: 0,\n            detailResult: {\n                inputData: [],\n                resultList: [],\n            },\n            isSuccess: false,\n            message: '',\n        };\n        gameRecord.push(game);\n    };\n    //  게임 리셋\n    const resetGame = () => {\n        const currentGame = gameRecord[Math.max(0, gameRecord.length - 1)];\n        currentGame.end = (0,_formatDate__WEBPACK_IMPORTED_MODULE_1__.formatDate)(new Date());\n        isGameStarted = false;\n    };\n    // 게임이 시작됐는지 여부\n    const getIsGameStarted = () => isGameStarted;\n    //  입력 값 검사\n    const checkNum = (input) => {\n        const currentGame = gameRecord[Math.max(0, gameRecord.length - 1)];\n        if (!/^\\d{3}$/.test(input.trim())) {\n            return '3자리 숫자를 입력하세요';\n        }\n        const gameResult = (0,_compareNumbers__WEBPACK_IMPORTED_MODULE_0__.compareNumbers)(randomNumber, input);\n        chances--;\n        currentGame.attempt++;\n        currentGame.detailResult.inputData.push(input);\n        currentGame.detailResult.resultList.push(`strike: ${gameResult.strike}, ball: ${gameResult.ball}`);\n        if (gameResult.strike === 3) {\n            isGameStarted = false;\n            currentGame.isSuccess = true;\n            currentGame.end = (0,_formatDate__WEBPACK_IMPORTED_MODULE_1__.formatDate)(new Date());\n            currentGame.message = '3개의 숫자를 모두 맞히셨습니다.';\n            return `3개의 숫자를 모두 맞히셨습니다.\\n-------게임 종료-------`;\n        }\n        if (chances === 0) {\n            isGameStarted = false;\n            currentGame.isSuccess = false;\n            currentGame.end = (0,_formatDate__WEBPACK_IMPORTED_MODULE_1__.formatDate)(new Date());\n            currentGame.message = '3개의 숫자를 모두 맞히지 못하셨습니다.';\n            return `3개의 숫자를 모두 맞히지 못하셨습니다.\\n-------게임 종료-------`;\n        }\n        return gameResult.ball === 0 ? '낫싱' : `strike: ${gameResult.strike}, ball: ${gameResult.ball}`;\n    };\n    const getGameRecords = () => {\n        return gameRecord.map((record) => ({\n            id: record.id,\n            start: record.start,\n            end: record.end,\n            attempt: record.attempt,\n        }));\n    };\n    const getDetailGameRecords = (id) => {\n        const record = gameRecord.find((record) => record.id === id);\n        if (!record) {\n            return '기록이 없습니다.';\n        }\n        let detail = `${record.id}번 게임 결과 \\n `;\n        record.detailResult.inputData.forEach((input, index) => {\n            const result = record.detailResult.resultList[index];\n            detail += `숫자를 입력해주세요: ${input}\\n${result}\\n`;\n        });\n        if (record.message) {\n            detail += `\\n${record.message}\\n-------기록 종료-------`;\n        }\n        return detail;\n    };\n    const getTotalListRecords = () => {\n        const successfulGames = gameRecord.filter((record) => record.isSuccess);\n        if (successfulGames.length === 0) {\n            return '성공한 기록이 없습니다.';\n        }\n        const totalListRecords = successfulGames\n            .map((record) => ({\n            id: record.id,\n            attempt: record.attempt,\n        }))\n            .sort((a, b) => a.attempt - b.attempt);\n        const totalAllRecords = totalListRecords.reduce((acc, cur) => {\n            return acc + cur.attempt;\n        }, 0);\n        const averageAttempt = totalAllRecords / totalListRecords.length;\n        const first = totalListRecords[0];\n        const last = totalListRecords[totalListRecords.length - 1];\n        return `\n    가장 적은 횟수: ${first.attempt}회 - [${first.id}]\n    가장 많은 횟수: ${last.attempt}회 - [${last.id}]\n    평균횟수: ${averageAttempt.toFixed(2)}회\n    \n    -------통계 종료-------\n        `;\n    };\n    return {\n        startGame,\n        resetGame,\n        checkNum,\n        getIsGameStarted,\n        getGameRecords,\n        getDetailGameRecords,\n        getTotalListRecords,\n    };\n};\n\n\n//# sourceURL=webpack:///./src/utils/game.ts?");

/***/ }),

/***/ "./src/utils/randomNumber.ts":
/*!***********************************!*\
  !*** ./src/utils/randomNumber.ts ***!
  \***********************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

eval("__webpack_require__.r(__webpack_exports__);\n/* harmony export */ __webpack_require__.d(__webpack_exports__, {\n/* harmony export */   generateRandomNum: () => (/* binding */ generateRandomNum)\n/* harmony export */ });\nconst generateRandomNum = () => {\n    let random = new Set();\n    while (random.size < 3) {\n        const number = Math.floor(Math.random() * 9) + 1;\n        random.add(number.toString());\n    }\n    return Array.from(random);\n};\n\n\n//# sourceURL=webpack:///./src/utils/randomNumber.ts?");

/***/ }),

/***/ "./src/utils/updateGameMessage.ts":
/*!****************************************!*\
  !*** ./src/utils/updateGameMessage.ts ***!
  \****************************************/
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

eval("__webpack_require__.r(__webpack_exports__);\n/* harmony export */ __webpack_require__.d(__webpack_exports__, {\n/* harmony export */   updateGameMessage: () => (/* binding */ updateGameMessage)\n/* harmony export */ });\nconst updateGameMessage = (element, content) => {\n    element.textContent = content;\n};\n\n\n//# sourceURL=webpack:///./src/utils/updateGameMessage.ts?");

/***/ })

/******/ 	});
/************************************************************************/
/******/ 	// The module cache
/******/ 	var __webpack_module_cache__ = {};
/******/ 	
/******/ 	// The require function
/******/ 	function __webpack_require__(moduleId) {
/******/ 		// Check if module is in cache
/******/ 		var cachedModule = __webpack_module_cache__[moduleId];
/******/ 		if (cachedModule !== undefined) {
/******/ 			return cachedModule.exports;
/******/ 		}
/******/ 		// Create a new module (and put it into the cache)
/******/ 		var module = __webpack_module_cache__[moduleId] = {
/******/ 			// no module.id needed
/******/ 			// no module.loaded needed
/******/ 			exports: {}
/******/ 		};
/******/ 	
/******/ 		// Execute the module function
/******/ 		__webpack_modules__[moduleId](module, module.exports, __webpack_require__);
/******/ 	
/******/ 		// Return the exports of the module
/******/ 		return module.exports;
/******/ 	}
/******/ 	
/************************************************************************/
/******/ 	/* webpack/runtime/define property getters */
/******/ 	(() => {
/******/ 		// define getter functions for harmony exports
/******/ 		__webpack_require__.d = (exports, definition) => {
/******/ 			for(var key in definition) {
/******/ 				if(__webpack_require__.o(definition, key) && !__webpack_require__.o(exports, key)) {
/******/ 					Object.defineProperty(exports, key, { enumerable: true, get: definition[key] });
/******/ 				}
/******/ 			}
/******/ 		};
/******/ 	})();
/******/ 	
/******/ 	/* webpack/runtime/hasOwnProperty shorthand */
/******/ 	(() => {
/******/ 		__webpack_require__.o = (obj, prop) => (Object.prototype.hasOwnProperty.call(obj, prop))
/******/ 	})();
/******/ 	
/******/ 	/* webpack/runtime/make namespace object */
/******/ 	(() => {
/******/ 		// define __esModule on exports
/******/ 		__webpack_require__.r = (exports) => {
/******/ 			if(typeof Symbol !== 'undefined' && Symbol.toStringTag) {
/******/ 				Object.defineProperty(exports, Symbol.toStringTag, { value: 'Module' });
/******/ 			}
/******/ 			Object.defineProperty(exports, '__esModule', { value: true });
/******/ 		};
/******/ 	})();
/******/ 	
/************************************************************************/
/******/ 	
/******/ 	// startup
/******/ 	// Load entry module and return exports
/******/ 	// This entry module can't be inlined because the eval devtool is used.
/******/ 	var __webpack_exports__ = __webpack_require__("./src/index.ts");
/******/ 	
/******/ })()
;